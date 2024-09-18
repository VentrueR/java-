package test.Serlize;
import java.io.*;

/**
 * @Author: 韩睿
 * @Description:
 * @DateTime: 2024/9/1 13:38
 **/
public class ToSerlize {
    public static final String targetAdress = "./Test/src/main/resources/userinfo.txt";
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        User user = new User("hr", "6");
        System.out.println(user);

        try {
        ObjectOutputStream op = new ObjectOutputStream(new FileOutputStream(targetAdress));
        op.writeObject(user);
        op.close();
        }catch (IOException e){
            e.printStackTrace();
        }

        try {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(targetAdress));
        User user1 = (User) in.readObject();
        System.out.println(user1);
        in.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
