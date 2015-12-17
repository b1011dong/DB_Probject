package data;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class QueryHelper {

	static String url = "jdbc:oracle:thin:@59.23.203.192:1521:oradong";
	static String user = "DBPROJECT";
	static String pass = "DBPROJECT";
	static Connection conn = null;
	static String sql = null;
	static String query = null;
	static boolean selectOrNot = false;
	
	public static String QuerySetString(String query, String name, String value)
    {
        return (query + " ").replaceAll(name, "'" + value + "' ");
    }
	
	public static String QuerySetNumber(String query, String name, int value)
    {
        return (query + " ").replaceAll(name,""+value);
    }
	
	
	// ȸ�� ����
	public static JSONObject Insert_Register_Person(String userId, String userPassword, String major, int person_num, int phoneNumber,String email, String auth, String name ) 
	{
		selectOrNot = false;
		String sql = "insert into person values(id, password, major, person_num, phone,email, auth, name)";
		
		sql = QuerySetString(sql,"id", userId);
		sql = QuerySetString(sql,"password", userPassword);
		sql = QuerySetString(sql,"major", major);
		sql = QuerySetNumber(sql,"person_num", person_num);
		sql = QuerySetNumber(sql,"email", phoneNumber);
		sql = QuerySetString(sql,"auth", auth);
		sql = QuerySetString(sql,"name", name);
		
		JSONObject result = getQueryResult(sql);
		return result;
		
	}
	
	// �α��� �� �� ���� �޾ƿ�
	public static JSONObject Select_Login(String userID, String userPassword)
	{
		selectOrNot = true;
		String sql = "select id, password from person where id=(���̵�) and password = (��й�ȣ)";
		sql = QuerySetString(sql, "(���̵�)", userID);
		sql = QuerySetString(sql, "(��й�ȣ)", userPassword);
		JSONObject result = getQueryResult(sql);
		return result;
	}
	
	// ���� �Խ��� Ÿ��Ʋ ����Ʈ�� �޾ƿ�
	public static JSONObject Select_Quesion_Title_List(String subjectID)
	{
		selectOrNot = true;
		String sql = "select rownum, numb, title, student_id from question where code=(�����ڵ�)";
		sql = QuerySetString(sql,"(�����ڵ�)", subjectID); 
		JSONObject result = getQueryResult(sql);
		return result;
	}
	
	// ���� �Խ��� Ÿ��Ʋ ����Ʈ�� �޾ƿ�
	public static JSONObject Select_Quesion_User_Data(String userID, String subjectID)
	{
		selectOrNot = true;
		String sql = "select code, numb, student_id, title, contents, attechedname, post_date, secret from question where student_id = (���̵�) and code=(�����ڵ�)";
		sql = QuerySetString(sql,"(���̵�)", userID);
		sql = QuerySetString(sql,"(�����ڵ�)", subjectID);
		JSONObject result = getQueryResult(sql);
		return result;
	}

	// ���� �Խ��ǿ� �亯 ���� �޾ƿ�.
	public static JSONObject Select_Quesion_User_Answer(String userID, String subjectID)
	{
		selectOrNot = true;
		String sql = "select r.numb, r.super_id, r.contents, r.attechedname, r.post_date, r.code from question q,reply r where q.code=(�����ڵ�) q.student_id = (���̵�) and q.numb = r.numb";
		sql = QuerySetString(sql,"(���̵�)", userID);
		sql = QuerySetString(sql,"(�����ڵ�)", userID);
		JSONObject result = getQueryResult(sql);
		return result;
	}
	
	// 		���� �ø���
	public static JSONObject Insert_Quesion_User_Answer(String subCode, int boardNumber, String studentId, String title, String content, String fileName, String secret)
	{
		selectOrNot = false;
		String sql = "Insert into question(code,numb,student_id,title,contents,attechedname,post_date,secret) values(�����ڵ�, (select count(*)+1 from question) , �л�id, Ÿ��Ʋ, ����, ÷�������̸�, sysdate, ���)";
		sql = QuerySetString(sql,"�����ڵ�", subCode);
		sql = QuerySetString(sql,"�л�id",studentId );
		sql = QuerySetString(sql,"Ÿ��Ʋ", title);
		sql = QuerySetString(sql,"����", content);
		sql = QuerySetString(sql,"÷�������̸�", fileName);
		sql = QuerySetString(sql,"���", secret);
		
		JSONObject result = getQueryResult(sql);
		return result;
	}
	
	//  	���� �ֱ�
	public static JSONObject Insert_Quesion_Supervisor_Reply(int quesionNum, String superID, String content, String fileName, String subCode)
	{
		selectOrNot = false;
		String sql = "Insert into reply(numb,super_id,contents,attechedname,post_date,code) values(questoin��ȣ ,�����ڹ�ȣ, ����, ÷�������̸�, sysdate, �����ڵ�)";
		sql = QuerySetNumber(sql,"questoin��ȣ",quesionNum);
		sql = QuerySetString(sql,"�����ڹ�ȣ",superID );
		sql = QuerySetString(sql,"����", content);
		sql = QuerySetString(sql,"÷�������̸�", fileName);
		sql = QuerySetString(sql,"�����ڵ�", subCode);
		JSONObject result = getQueryResult(sql);
		return result;	
	}
	
	
	//		���� �Խ��ǿ� ������ �� �����
	public static JSONObject Select_Subject_Board_Title(String subjectCode)
	{
		selectOrNot = true;
		String sql = "select r.NUM,r.TITLE,r.ATTACHED_NAME,r.CREATE_DATE,r.DEADLINE from REPORT r where r.CODE = @�ش�����ڵ� ORDER BY r.NUM";
		sql.replace("@�ش�����ڵ�", subjectCode);
		JSONObject result = getQueryResult(sql);
		return result;	
	}
	
	
	//���� �Խ��ǿ��� Ŭ�� ���� �� ������ �����ִ� Method @dongHee
	public static JSONObject getContentfromReport(int reportNum)
	{
		selectOrNot = false;
		String sql = "select r.content from REPORT r where r.NUM = 	@Ŭ���Խù���";
		sql.replace("@Ŭ���Խù���", reportNum+"");
		JSONObject result = getQueryResult(sql);
		return result;
	}
	
	//���� ������ �ѱ� �Խù� ����!!!! @dongHee
	public static JSONObject getExpiredReportList(int reportNum)
	{
		selectOrNot = false;
		String sql = "select r.NUM,r.TITLE,r.ATTACHED_NAME,r.CREATE_DATE,r.DEADLINE from REPORT r where r.CREATE_DATE > r.DEADLINE ORDER BY r.NUM";
		JSONObject result = getQueryResult(sql);
		return result;
	}
	//���� ���� subjectCode->���� �ڵ�, title->����, contents->����, attachedFileName->÷������ �̸� @dongHee
	public static JSONObject writeReport(int subjectCode,String title,String contents,String attachedFileName)
	{
		selectOrNot = false;
		String sql = "insert INTO REPORT valuse(@�ش�����ڵ�,(select count(*) from REPORT r where r.CODE = @�ش�����ڵ� ),(select s.PROFESSOR_ID from SUBJECT s where s.CODE = @�ش�����ڵ� AND ),NULL,@����,@����,@÷�������̸�,SYSDATE)";
		sql.replace("@�ش�����ڵ�", ""+subjectCode);
		sql.replace("@����", title);
		sql.replace("@����", contents);
		sql.replace("@÷�������̸�", attachedFileName);
		JSONObject result = getQueryResult(sql);
		return result;
	}
	// �׽�Ʈ�� �Լ�~
	public static JSONObject SelectTest()
	{
		selectOrNot = true;
		String sql = "SELECT * FROM JAVA_EMPLOYEE";
		JSONObject result = getQueryResult(sql);
		return result;
	}
	
	// �׽�Ʈ�� �Լ�~
	public static JSONObject instertTest()
	{
		selectOrNot = false;
		String sql = "insert into JAVA_EMPLOYEE values(10, '����z', 'f', 300, 100, 20, 2, '2014/12/04')";
		JSONObject result = getQueryResult(sql);
		
		return result;
	}
	
	
	
	
	private static JSONObject getQueryResult(String sql)
	{
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver impoert!!!");
		}catch(ClassNotFoundException e){
		System.err.println("err = " + e.getMessage());
		System.exit(1);
		}
		try{
			conn = DriverManager.getConnection(url,user,pass);
			Statement stmt = conn.createStatement();
			System.out.println("conn success!!!");
			
			if(selectOrNot)
			{
				ResultSet reset = stmt.executeQuery(sql);
				
				JSONObject json = getJSONObjectFromResultSet(reset);
				
				if ( json != null )
		        {
		            return json;
		        }
			}
			else
			{
				int result = stmt.executeUpdate(sql);
				
				JSONObject json = new JSONObject();
				json.put("result", result);
		        return json;
		        
			}
			
		}catch(SQLException e){
			System.err.println("sql err = " + e.getMessage());
			System.exit(1);
		}catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	private static JSONObject getJSONObjectFromResultSet(ResultSet rs)
    {
        try {
            JSONArray jsonArray = new JSONArray();
            while(rs.next())
            {
                ResultSetMetaData rsmd = rs.getMetaData();
                int numColumns = rsmd.getColumnCount();
                JSONObject obj = new JSONObject();
                for ( int i = 1; i < numColumns + 1; i++ )
                {
                    String column_name = rsmd.getColumnName(i);
                    switch( rsmd.getColumnType( i ) ) {
                        case java.sql.Types.ARRAY:
                            obj.put(column_name, rs.getArray(column_name));     break;
                        case java.sql.Types.DECIMAL:
                        case java.sql.Types.BIGINT:
                            obj.put(column_name, rs.getInt(column_name));       break;
                        case java.sql.Types.BOOLEAN:
                            obj.put(column_name, rs.getBoolean(column_name));   break;
                        case java.sql.Types.BLOB:
                            obj.put(column_name, rs.getBlob(column_name));      break;
                        case java.sql.Types.DOUBLE:
                            obj.put(column_name, rs.getDouble(column_name));    break;
                        case java.sql.Types.FLOAT:
                            obj.put(column_name, rs.getFloat(column_name));     break;
                        case java.sql.Types.INTEGER:
                            obj.put(column_name, rs.getInt(column_name));       break;
                        case java.sql.Types.NVARCHAR:
                            obj.put(column_name, rs.getNString(column_name));   break;
                        case java.sql.Types.VARCHAR:
                            obj.put(column_name, rs.getString(column_name));    break;
                        case java.sql.Types.TINYINT:
                            obj.put(column_name, rs.getInt(column_name));       break;
                        case java.sql.Types.SMALLINT:
                            obj.put(column_name, rs.getInt(column_name));       break;
                        case java.sql.Types.DATE:
                            obj.put(column_name, rs.getDate(column_name));      break;
                        case java.sql.Types.TIMESTAMP:
                            obj.put(column_name, rs.getTimestamp(column_name)); break;
                        case java.sql.Types.CLOB:
                            try {
                                obj.put(column_name, new String(rs.getBytes(column_name), "EUC-KR"));
                            } catch (UnsupportedEncodingException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            }	break;
                        default:
                            obj.put(column_name, rs.getObject(column_name));	break;
                    }
                }
                jsonArray.put(obj);
            }
            JSONObject result = new JSONObject();
            result.put("result", jsonArray);
            return result;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return null;
    }
}
