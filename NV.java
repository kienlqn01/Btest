import java.time.LocalDate;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class NV {
    private String maNV;
    private String hoTen;
    private LocalDate ngayVaoLam;
    private double luongKhoiDiem;
    private String cachTra; // "duAn" hoặc "ngay"

    public NV(String maNV, String hoTen, LocalDate ngayVaoLam, double luongKhoiDiem, String cachTra) {
        this.maNV = maNV;
        this.hoTen = hoTen;
        this.ngayVaoLam = ngayVaoLam;
        this.luongKhoiDiem = luongKhoiDiem;
        this.cachTra = cachTra;
    }

    public String getMaNV() {
        return maNV;
    }

    public String getCachTra() {
        return cachTra;
    }

    @Override
    public String toString() {
        return "NV{" +
                "maNV='" + maNV + '\'' +
                ", hoTen='" + hoTen + '\'' +
                ", ngayVaoLam=" + ngayVaoLam +
                ", luongKhoiDiem=" + luongKhoiDiem +
                ", cachTra='" + cachTra + '\'' +
                '}';
    }

    public static HashMap<String, NV> nhapDanhSachNhanVien() {
        HashMap<String, NV> dsNV = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.print("Nhập mã nhân viên (nhập '#' để kết thúc): ");
                String maNV = scanner.nextLine();
                if (maNV.equals("#")) break;
                if (dsNV.containsKey(maNV)) {
                    System.out.println("Mã nhân viên đã tồn tại. Vui lòng nhập mã khác.");
                    continue;
                }

                System.out.print("Nhập họ tên: ");
                String hoTen = scanner.nextLine();

                System.out.print("Nhập ngày vào làm (yyyy-MM-dd): ");
                LocalDate ngayVaoLam = LocalDate.parse(scanner.nextLine());

                System.out.print("Nhập lương khởi điểm: ");
                double luongKhoiDiem = Double.parseDouble(scanner.nextLine());

                System.out.print("Nhập cách trả lương ('duAn' hoặc 'ngay'): ");
                String cachTra = scanner.nextLine();
                if (!cachTra.equals("duAn") && !cachTra.equals("ngay")) {
                    System.out.println("Cách trả không hợp lệ. Vui lòng nhập lại.");
                    continue;
                }

                NV nv = new NV(maNV, hoTen, ngayVaoLam, luongKhoiDiem, cachTra);
                dsNV.put(maNV, nv);
            } catch (Exception e) {
                System.out.println("Dữ liệu nhập không hợp lệ, vui lòng nhập lại.");
            }
        }

        return dsNV;
    }
}
