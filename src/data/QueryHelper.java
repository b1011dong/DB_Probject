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
	
	
	// 회원 가입
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
	
	// 로그인 할 떄 정보 받아옴
	public static JSONObject Select_Login(String userID, String userPassword)
	{
		selectOrNot = true;
		String sql = "select id, password from person where id=(아이디) and password = (비밀번호)";
		sql = QuerySetString(sql, "(아이디)", userID);
		sql = QuerySetString(sql, "(비밀번호)", userPassword);
		JSONObject result = getQueryResult(sql);
		return result;
	}
	
	// 질문 게시판 타이틀 리스트를 받아옴
	public static JSONObject Select_Quesion_Title_List(String subjectID)
	{
		selectOrNot = true;
		String sql = "select rownum, numb, title, student_id from question where code=(과목코드)";
		sql = QuerySetString(sql,"(과목코드)", subjectID); 
		JSONObject result = getQueryResult(sql);
		return result;
	}
	
	// 질문 게시판 타이틀 리스트를 받아옴
	public static JSONObject Select_Quesion_User_Data(String userID, String subjectID)
	{
		selectOrNot = true;
		String sql = "select code, numb, student_id, title, contents, attechedname, post_date, secret from question where student_id = (아이디) and code=(과목코드)";
		sql = QuerySetString(sql,"(아이디)", userID);
		sql = QuerySetString(sql,"(과목코드)", subjectID);
		JSONObject result = getQueryResult(sql);
		return result;
	}

	// 질문 게시판에 답변 내용 받아옴.
	public static JSONObject Select_Quesion_User_Answer(String userID, String subjectID)
	{
		selectOrNot = true;
		String sql = "select r.numb, r.super_id, r.contents, r.attechedname, r.post_date, r.code from question q,reply r where q.code=(과목코드) q.student_id = (아이디) and q.numb = r.numb";
		sql = QuerySetString(sql,"(아이디)", userID);
		sql = QuerySetString(sql,"(과목코드)", userID);
		JSONObject result = getQueryResult(sql);
		return result;
	}
	
	// 		질문 올리기
	public static JSONObject Insert_Quesion_User_Answer(String subCode, int boardNumber, String studentId, String title, String content, String fileName, String secret)
	{
		selectOrNot = false;
		String sql = "Insert into question(code,numb,student_id,title,contents,attechedname,post_date,secret) values(과목코드, (select count(*)+1 from question) , 학생id, 타이틀, 내용, 첨부파일이름, sysdate, 비밀)";
		sql = QuerySetString(sql,"과목코드", subCode);
		sql = QuerySetString(sql,"학생id",studentId );
		sql = QuerySetString(sql,"타이틀", title);
		sql = QuerySetString(sql,"내용", content);
		sql = QuerySetString(sql,"첨부파일이름", fileName);
		sql = QuerySetString(sql,"비밀", secret);
		
		JSONObject result = getQueryResult(sql);
		return result;
	}
	
	//  	응답 넣기
	public static JSONObject Insert_Quesion_Supervisor_Reply(int quesionNum, String superID, String content, String fileName, String subCode)
	{
		selectOrNot = false;
		String sql = "Insert into reply(numb,super_id,contents,attechedname,post_date,code) values(questoin번호 ,관리자번호, 내용, 첨부파일이름, sysdate, 과목코드)";
		sql = QuerySetNumber(sql,"questoin번호",quesionNum);
		sql = QuerySetString(sql,"관리자번호",superID );
		sql = QuerySetString(sql,"내용", content);
		sql = QuerySetString(sql,"첨부파일이름", fileName);
		sql = QuerySetString(sql,"과목코드", subCode);
		JSONObject result = getQueryResult(sql);
		return result;	
	}
	
	
	//		과제 게시판에 제목이 될 내용들
	public static JSONObject Select_Subject_Board_Title(String subjectCode)
	{
		selectOrNot = true;
		String sql = "select r.NUM,r.TITLE,r.ATTACHED_NAME,r.CREATE_DATE,r.DEADLINE from REPORT r where r.CODE = @해당과목코드 ORDER BY r.NUM";
		sql.replace("@해당과목코드", subjectCode);
		JSONObject result = getQueryResult(sql);
		return result;	
	}
	
	
	//과제 게시판에서 클릭 했을 시 내용을 보여주는 Method @dongHee
	public static JSONObject getContentfromReport(int reportNum)
	{
		selectOrNot = false;
		String sql = "select r.content from REPORT r where r.NUM = 	@클릭게시물번";
		sql.replace("@클릭게시물번", reportNum+"");
		JSONObject result = getQueryResult(sql);
		return result;
	}
	
	//제출 기한을 넘긴 게시물 보기!!!! @dongHee
	public static JSONObject getExpiredReportList(int reportNum)
	{
		selectOrNot = false;
		String sql = "select r.NUM,r.TITLE,r.ATTACHED_NAME,r.CREATE_DATE,r.DEADLINE from REPORT r where r.CREATE_DATE > r.DEADLINE ORDER BY r.NUM";
		JSONObject result = getQueryResult(sql);
		return result;
	}
	//과제 쓰기 subjectCode->과목 코드, title->제목, contents->내용, attachedFileName->첨부파일 이름 @dongHee
	public static JSONObject writeReport(int subjectCode,String title,String contents,String attachedFileName)
	{
		selectOrNot = false;
		String sql = "insert INTO REPORT valuse(@해당과목코드,(select count(*) from REPORT r where r.CODE = @해당과목코드 ),(select s.PROFESSOR_ID from SUBJECT s where s.CODE = @해당과목코드 AND ),NULL,@제목,@내용,@첨부파일이름,SYSDATE)";
		sql.replace("@해당과목코드", ""+subjectCode);
		sql.replace("@제목", title);
		sql.replace("@내용", contents);
		sql.replace("@첨부파일이름", attachedFileName);
		JSONObject result = getQueryResult(sql);
		return result;
	}
	// 테스트용 함수~
	public static JSONObject SelectTest()
	{
		selectOrNot = true;
		String sql = "SELECT * FROM JAVA_EMPLOYEE";
		JSONObject result = getQueryResult(sql);
		return result;
	}
	
	// 테스트용 함수~
	public static JSONObject instertTest()
	{
		selectOrNot = false;
		String sql = "insert into JAVA_EMPLOYEE values(10, '월매z', 'f', 300, 100, 20, 2, '2014/12/04')";
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
