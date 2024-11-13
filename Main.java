import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        // Nhập danh sách nhân viên
        HashMap<String, NV> dsNV = NV.nhapDanhSachNhanVien();

        // Khởi tạo đối tượng quản lý nhân viên
        QLNV qlnv = QLNV.getInstance();

        // Thêm observer
        qlnv.themQuanSat(new ThongBaoHR());
        qlnv.themQuanSat(new ThongBaoPM());

        // Thêm nhân viên vào hệ thống và gửi thông báo
        for (NV nv : dsNV.values()) {
            qlnv.themNhanVien(nv);
        }
    }
}
