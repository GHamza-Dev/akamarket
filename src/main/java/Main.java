import com.akamarket.akamarket.dao.CategoryDao;
import com.akamarket.akamarket.dao.Dao;
import com.akamarket.akamarket.entity.Category;
import com.akamarket.akamarket.entity.Market;
import com.oracle.wls.shaded.org.apache.xpath.res.XPATHErrorResources_ru;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Main {

    private static final int i = 44;

    public static void main(String[] args) {

//        for(int i=0;i<100;i++){
//            System.out.print(i);
//            i++;
//            break;
//        }
//        System.out.print(i);

        print30(1);

    }

    public static void print30(int i){
        if (i==10) return;
        print30(i+1);
        System.out.print(i+" ");
    }

    // 29
    public static void print29(int i){
        System.out.print(i+" ");
        if (i == 3) return;
        print29(i+1);
        System.out.print(i+" ");
    }

    public static boolean p(int i){
        System.out.print(i+" ");
        return true;
    }

    public static void print(){
        for(p(1);p(2);p(3)){
            System.out.print("Body ");
            break;
        }
    }
}
