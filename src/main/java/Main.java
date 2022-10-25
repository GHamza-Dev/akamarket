import com.akamarket.akamarket.dao.CategoryDao;
import com.akamarket.akamarket.dao.Dao;
import com.akamarket.akamarket.entity.Category;
import com.akamarket.akamarket.entity.Market;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        CategoryDao categoryDao = new CategoryDao();
        for (Category cat: categoryDao.getAll()) {
            System.out.println(cat.getCategoryName());
        }

    }
}
