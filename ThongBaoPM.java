public class ThongBaoPM implements QuanSat {
    @Override
    public void capNhat(String thongBao, NV nv) {
        System.out.println("Đội dự án nhận thông báo: " + thongBao + " - " + nv);
    }
}
