import org.springframework.util.DigestUtils;

public class jiamijiemi {
    private static final String slat = "&%5123***&&%%$$#@";
    String str = "fffrfeewgsrfdhn";
    String base = str +"/"+slat;
    String md5 = DigestUtils.md5DigestAsHex(base.getBytes());

//    System.out.println(md5);

}
