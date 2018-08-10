package Dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.pojo.Books;
import com.pojo.Cart;

public class bookCollection implements bookCollectionDao {

	private static Map<Integer, Books> bookdb = new HashMap<Integer, Books>();
	private static Map<Integer, Cart> cart = new HashMap<Integer, Cart>();

	private static Books b1 = new Books(101, "Alchemist", "Philosophy", 499);
	private static Books b2 = new Books(102, "twilight", "Romance and drama", 999);
	private static Books b3 = new Books(103, "All your Perfects", "Romance", 400);

	static {
		bookdb.put(b1.getId(), b1);
		System.out.println(b1.getId() + "---------------");
		bookdb.put(b2.getId(), b2);
		bookdb.put(b3.getId(), b3);
	}

	@Override
	public Collection<Books> ViewAllBooks() {

		return bookdb.values();
	}

	@Override
	public Collection<Cart> ViewCart() {

		return null;
	}

	@Override
	public void addBook(int id) {

		if (cart.get(id) == null) {
			for (Books book : ViewAllBooks()) {
				if (book.getId() == id) {
					Cart crt = new Cart(1, book);
					cart.put(id, crt);
				}
			}
		} else {
			Cart crt = cart.get(id);
			crt.setQuantity(crt.getQuantity() + 1);
		}
	}

	@Override
	public void delete(int id) {


	}

	@Override
	public int getTotalQuantity() {

		return 0;
	}

	@Override
	public double getTotalPrice() {

		return 0;
	}

}
