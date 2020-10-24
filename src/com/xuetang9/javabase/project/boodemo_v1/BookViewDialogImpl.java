package project.bookdemo;

import javax.swing.*;

/**
 * @Author WangHaojie
 * @Description 使用对话框升级的图形界面
 * @Date Created in 2020/10/24 22:14
 */
public class BookViewDialogImpl extends AbstractBookView {
    private BookBiz bookBiz = null;

    public BookViewDialogImpl() {
        bookBiz = new BookBiz();
    }

    @Override
    public String showMainView() {
        String strMenu = "\n图书管理系统 >> 主菜单\n";
        strMenu += "1、新增图书\t2、删除图书\t3、查看所有图书\t4、按编号查询\t5、入库\t6、出库\t7、退出\n";
        strMenu += "请选择：";
        String result = JOptionPane.showInputDialog(strMenu);  //显示输入对话框
        if (result == null) result = "7";  //用户点击了取消按钮
        return result;
    }

    @Override
    public void showOutStore() {
        JOptionPane.showMessageDialog(null, "图书管理系统 >> 图书出库");
        String bookId = JOptionPane.showInputDialog("请输入出库图书编号：");
        int bookCount = Integer.parseInt(JOptionPane.showInputDialog("出库图书的数量："));
        if (bookBiz.outStore(bookId, bookCount)) {
            JOptionPane.showMessageDialog(null, "出库成功！");
            showBooks(null);
        } else {
            JOptionPane.showMessageDialog(null, "出库失败，请检查输入的图书编号或出库数量是否超限！");
        }
    }

    @Override
    public void showInStore() {
        //入库需要两个参数：图书id，入库的数量
        JOptionPane.showMessageDialog(null, "图书管理系统 >> 图书入库");
        String bookId = JOptionPane.showInputDialog("请输入入库图书编号：");
        int bookCount = Integer.parseInt(JOptionPane.showInputDialog("入库图书的数量："));
        if (bookBiz.inStore(bookId, bookCount)) {
            JOptionPane.showMessageDialog(null, "入库成功！");
            showBooks(null);
        } else {
            JOptionPane.showMessageDialog(null, "入库失败，请检查输入的图书编号！");
        }
    }

    @Override
    public void showFindById() {
        JOptionPane.showMessageDialog(null, "图书管理系统 >> 按编号查询");
        String bookId = JOptionPane.showInputDialog("请输入要查询的图书编号：");
        Book book = bookBiz.findById(bookId);
        if (book == null) {
            JOptionPane.showMessageDialog(null, "没有找到任何的图书信息！");
            return;
        }
        showBooks(book);
    }

    @Override
    public void showDelBookView() {
        JOptionPane.showMessageDialog(null, "图书管理系统 >> 删除图书");
        //暂时只实现根据id删除
        String delId = JOptionPane.showInputDialog("请输入要删除的图书编号：");
        Book delBook = new Book();
        delBook.setBookId(delId);
        if (bookBiz.delBook(delBook)) {//如果删除成功
            JOptionPane.showMessageDialog(null, "删除成功！");
            showBooks(null);    //打印默认的图书仓库，相当于刷新显示当前图书仓库中的内容
        } else {//删除失败
            JOptionPane.showMessageDialog(null, "删除失败！");
        }
    }

    @Override
    public Book showAddNewBookView() {
        Book newBook = new Book();
        String bookId = null;
        String bookName = null;
        int count = -1;
        //注意：这里的三个变量输入时需要验证用户输入数据的合法性
        bookId = JOptionPane.showInputDialog("请输入图书编号：");
        bookName = JOptionPane.showInputDialog("图书名称：");
        count = Integer.parseInt(JOptionPane.showInputDialog("库存量："));

        newBook.setBookId(bookId);
        newBook.setBookName(bookName);
        newBook.setCount(count);
        if (bookBiz.addBook(newBook)) {
            JOptionPane.showMessageDialog(null, "添加成功！");
        } else {
            JOptionPane.showMessageDialog(null, "添加失败！");
        }
        return newBook;
    }

    @Override
    public void showBooks(Book... bookArray) {
        StringBuffer strBooks= new StringBuffer("内部编号\t名称\t库存\n");
        if (bookArray == null) {
            bookArray = Datas.BookStore;
        }
        int bookCount = bookBiz.getBookCount(bookArray);
        for (int i = 0; i < bookCount; i++) {
            strBooks.append(bookArray[i].getBookId()).append("\t")
                    .append(bookArray[i].getBookName()).append("\t")
                    .append(bookArray[i].getCount()).append("\n");
        }
        JOptionPane.showMessageDialog(null, strBooks);
    }
}
