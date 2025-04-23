
package hust.soict.hedspi.aims;

import java.util.ArrayList;
import java.util.List;

import hust.soict.hedspi.aims.media.Media;

public class Store {
    private List<Media> itemsInStore = 
            new ArrayList<>(); 
    public void addMedia (Media item)
    {   // Method cho việc thêm item
            //Thêm item vào store và thông báo thêm thành công
            itemsInStore.add(item);
            System.out.println("The item has been added");
    }
    
    public void removeMedia (Media item)
    {       // Method cho việc loại bỏ disc
            if (itemsInStore.isEmpty())
            {   //Nếu list trống thì thông báo cart trống
                System.out.println("The shop is empty");
                return;
            }
            if (itemsInStore.remove(item))
            {   // Nếu loại bỏ thành công thì gửi thông báo
                System.out.println("The item is removed successfully");
            }
            else
            {   // Nếu không loại bỏ thành công thì gửi thông báo disc không có trong cart
                System.out.println("The item is not in the shop");
            }
        
    }
    
    public void showStore()
    {   // Method để liệt kê những gì có trong store và chi phí của chúng
        int i = 1;
        System.out.println("***********************Store***********************");
        for (Media item : itemsInStore) {
             System.out.println(i + ".item - " + item.toString());
             i++;
        // Duyệt lần lượt qua Store và in kết quả
        }
        System.out.println("***************************************************");
    }
    
    public Media searchByTitle(String Title)
    { // Method để tìm bằng title
        int count = 1;
        Media result = null;
        for (Media item : itemsInStore) {
            if (item.isMatch(Title))
                {// Duyệt lần lượt qua cart và kiểm tra xem title của dvd có chứa xâu dùng để tra không
                System.out.println("Item -" + item.toString());
                result = item;
                count ++;
                // nếu có thì in ra và tăng count
                }
            
       }
        if (count == 1)
        {   //Nếu count không đổi thì in ra không tìm được
            System.out.println("No results found");
            return null;
            //trả về null nếu không tìm thấy
        }
        return result;
        //trả về kết quả cuối thỏa mãn
        }
    }

