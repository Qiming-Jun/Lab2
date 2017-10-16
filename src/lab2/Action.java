package lab2;
import java.io.UnsupportedEncodingException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
public class Action {
    
    ServletRequest request = ServletActionContext.getRequest();
    HttpServletRequest req = (HttpServletRequest) request;
    HttpSession session = req.getSession();
    private String username;
    private String title;
    private String isbn;
    private String name;
    private String publisher;
    private String publishdate;
    private String price;
    private String age;
    private String country;
    private String authorid;
    static int flag;
    
    private String indexMessage;
    
    public String getIndexMessage() {
    	return indexMessage;
    }
    
    public String getUsername(){
        return username;
    }
    public String getIsbn(){
        return isbn;
    }
    public String getTitle(){
        return title;
    }
    public String getName(){
        return name;
    }
    public String getAuthorid(){
        return authorid;
    }
    
    
/*    public void setIndexMessage(String indexMessage) throws UnsupportedEncodingException {
    //	this.indexMessage = new String(indexMessage.getBytes("ISO-8859-1"),"utf-8");
    	this.indexMessage = indexMessage;
    }
    public void setUsername(String username) throws UnsupportedEncodingException {
        this.username = new String(username.getBytes("ISO-8859-1"),"utf-8");
    }
    public void setAuthorid(String authorid) {
        this.authorid = authorid;
    }
    public void setTitle(String title) throws UnsupportedEncodingException {
    //    this.title = new String(title.getBytes("ISO-8859-1"),"utf-8");
    	 this.title = title;
    }
    public void setName(String name) throws UnsupportedEncodingException {
        this.name =new String(name.getBytes("ISO-8859-1"),"utf-8");
    }
    public void setPublisher(String publisher) throws UnsupportedEncodingException {
        this.publisher = new String(publisher.getBytes("ISO-8859-1"),"utf-8");
    }
    public void setPublishdate(String publishdate) {
        this.publishdate = publishdate;
    }
    public void setPrice(String price) {
        this.price = price;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public void setAge(String age) {
        this.age = age;
    }
    public void setCountry(String country) throws UnsupportedEncodingException {
        this.country=new String(country.getBytes("ISO-8859-1"),"utf-8");
    }*/
    
    
    
    public void setIndexMessage(String indexMessage) throws UnsupportedEncodingException {
        //	this.indexMessage = new String(indexMessage.getBytes("ISO-8859-1"),"utf-8");
        	this.indexMessage = indexMessage;
    }
    public void setUsername(String username) throws UnsupportedEncodingException {
        this.username = username;
    }
    public void setAuthorid(String authorid) {
        this.authorid = authorid;
    }
    public void setTitle(String title) throws UnsupportedEncodingException {
        this.title = title;
    }
    public void setName(String name) throws UnsupportedEncodingException {
        this.name =name;
    }
    public void setPublisher(String publisher) throws UnsupportedEncodingException {
        this.publisher = publisher;
    }
    public void setPublishdate(String publishdate) {
        this.publishdate = publishdate;
    }
    public void setPrice(String price) {
        this.price = price;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public void setAge(String age) {
        this.age = age;
    }
    public void setCountry(String country) throws UnsupportedEncodingException {
        this.country=country;
    }
    
    
    // all struts logic here
    
    public String Search() {
    	DBConnection connect = new DBConnection();
    	
    	//判断是否是查询作者
    	List<String> authorList = new LinkedList<String>();
    	String sql1 = "select Name,AuthorID from Author where Name="+"'"+indexMessage+"'";
    	authorList = connect.select(sql1);
    	if(authorList.size()==0) {
    		sql1 = "select Name,AuthorID from Author where AuthorID="+"'"+indexMessage+"'";
    		authorList = connect.select(sql1);
    	}
    	
    	//判断是否是查询书籍
    	List<String> bookList = new LinkedList<String>();
    	String sql2 = "select Title,ISBN from Book where Title="+"'"+indexMessage+"'";
    	bookList = connect.select(sql2);
    	if(bookList.size()==0) {
    		sql2 = "select Title,ISBN from Book where ISBN="+"'"+indexMessage+"'";
    		bookList = connect.select(sql2);
    	}
        
    	session.setAttribute("authorList1", authorList);
        session.setAttribute("bookList1", bookList);
        return "SUCCESS";
        
    }
    
    public String showAuthorBook() {
    	List<String> authorList = new LinkedList<String>();
    	List<String> bookList = new LinkedList<String>();
    	
    	String sql1 = "select Name from Author;";
    	String sql2 = "select Title from Book;";
    //	sql = sql+"'"+username+"'";
    	
    	DBConnection connect = new DBConnection();
        authorList=connect.select(sql1);
        bookList=connect.select(sql2);
        
    //    if(authorList.size() == 0)
    //        return "AuthorEmpty";
        session.setAttribute("authorList", authorList);
        session.setAttribute("bookList", bookList);
        
        return "SUCCESS";
        
    }
    
    public String showAuthor() throws UnsupportedEncodingException {
    	List<String> authorInf = new LinkedList<String>();
    	List<String> authorBook = new LinkedList<String>();
    	
    	String sql1 = "select * from Author where Name=";
    //	String sql2 = "select Title from BookDB.Book";
    	sql1 = sql1+"'"+username+"'";
    	
    	DBConnection connect = new DBConnection();
    	authorInf=connect.select(sql1);
    	
    	System.out.println(sql1);
    	if(authorInf.size()==0)
    		return "FAILED";
    	
        for(int i=0; i<authorInf.size(); i=i+4) {
        	String sql2 = "select Title from Book where AuthorID="
        					+"'"+authorInf.get(i)+"'";
        	authorBook.addAll(connect.select(sql2));
        }
        
        session.setAttribute("username", username);
        session.setAttribute("authorInf", authorInf);
        session.setAttribute("authorBook", authorBook);
        return "SUCCESS";
        
    }
    
    public String showBook() {
    	DBConnection connect = new DBConnection();
    	List<String> bookInf = new LinkedList<String>();
    	List<String> authorInf = new LinkedList<String>();
    	
    	//获取此书的详细信息
    	String sql1 = "select * from Book where title="+"'"+title+"'";
    	bookInf=connect.select(sql1);
    	if(bookInf.size()==0) return "FAILED";
    	
    	//获取此书的作者
    	String theAutherID = bookInf.get(2);
    	String sql2 = "select * from Author where AuthorID=" + "'" + theAutherID + "'";
    	/*这里要不要判断Name是否搜索到*/
    	authorInf=connect.select(sql2);
    	
        session.setAttribute("authorInf1", authorInf);
        session.setAttribute("bookInf1", bookInf);
        session.setAttribute("theAuthorName", authorInf.get(1));
        
        return "SUCCESS";
        
    }
    
    public String addbook(){
    	DBConnection connect = new DBConnection();
    	
    	String sql1="select * from Book where ISBN="+"'"+isbn+"'";
    	if(connect.select(sql1).size()!=0)
    		return "ISBNEXIST";
    	
    	String sql2="select * from Author where AuthorID="+"'"+authorid+"'";
    	if(connect.select(sql2).size()==0)
    		return "NOAUTHOR";
    	
        String sql3="insert into Book(ISBN,Title,AuthorID,Publisher,PublishDate,Price) values"
        		+ "('"+isbn+"',"
        		+ "'"+title+"',"
        		+ "'"+authorid+"',"
        		+ "'"+publisher+"',"
        		+ "'"+publishdate+"',"
        		+ "'"+price+"')";
        
        int signal=connect.insert(sql3);
        if(signal==1)
            return "SUCCESS";
        else
            return "FAILED";
        
    }

    public String gotoedit(){
        return "SUCCESS";
    }
    public String edit(){
    	DBConnection connect = new DBConnection();
    	
    	String sql1="select * from Author where authorid="+"'"+authorid+"'";
    	if(connect.select(sql1).size()==0)
    		return "NOAUTHOR";
    	
    	String sql2="update Book set AuthorID="+"'"+authorid+"',"
    			+"Publisher="+"'"+publisher+"',"
    			+"PublishDate="+"'"+publishdate+"',"
    			+"Price="+"'"+price+"'"
    			+" where ISBN="+"'"+isbn+"'";
    	
    	int signal=connect.update(sql2);
        if(signal==1)
            return "SUCCESS";
        else
            return "FAILED";
    }
    
    public String addauthor(){
    	
    	DBConnection connect = new DBConnection();
    	
    	String sql1="select * from Author where AuthorID="+"'"+authorid+"'";
    	if(connect.select(sql1).size()!=0)
    		return "AUTHOREXIST";
    	
        String sql2="insert into Author(AuthorID,Name,Age,Country) values "
        		+ "('"+authorid+"',"
        		+ "'"+name+"',"
        		+ "'"+age+"',"
        		+ "'"+country+"')";
        
        int signal=connect.insert(sql2);
        if(signal==1)
            return "SUCCESS";
        else
            return "FAILED";
    	
    }
    public String delete(){
    	DBConnection connect = new DBConnection();
    	
        String sql1 ="delete from Book where ISBN="+"'"+isbn+"'";
        
        int signal=connect.delete(sql1);
        if(signal==1)
            return "SUCCESS";
        else
            return "FAILED";
    }
    
    public String deleteAuthor(){
    	DBConnection connect = new DBConnection();
    	
        String sql1 ="delete from Author where AuthorID="+"'"+authorid+"'";
        
        int signal=connect.delete(sql1);
        if(signal==1)
            return "SUCCESS";
        else
            return "FAILED";
    }
    /*public String addbook(){
        flag=1;
        String sql0="select * from Author where Name=?";
        Matcher m1 = p.matcher(sql0);
        String sql1 = m1.replaceFirst('"'+name+'"');
        DBConnection connect = new DBConnection();
        list=connect.select(sql1);
        list0=connect.select("select AuthorID from Author");
        if(list.size()==0){
            if(list0.size()==0)
                authorid="1";
            else
                authorid=String.valueOf(Integer.parseInt(Collections.max(list0))+1);
        }
        else
            authorid=list.get(0);
        if(list.size()==0)
            return "ADD";
        String sql="insert into Book(ISBN,Title,AuthorID,Publisher,PublishDate,Price) values(?,?,?,?,?,?)";
        m1 = p.matcher(sql);
        sql = m1.replaceFirst('"'+isbn+'"');
        m1 = p.matcher(sql);
        sql = m1.replaceFirst('"'+title+'"');
        m1 = p.matcher(sql);
        sql = m1.replaceFirst('"'+authorid+'"');
        m1 = p.matcher(sql);
        sql = m1.replaceFirst('"'+publisher+'"');
        m1 = p.matcher(sql);
        sql = m1.replaceFirst('"'+publishdate+'"');
        m1 = p.matcher(sql);
        sql = m1.replaceFirst('"'+price+'"');
        int signal=connect.insert(sql);
        if(signal==1)
            return "SUCCESS";
        else
            return "FAILED";
    }*/
}