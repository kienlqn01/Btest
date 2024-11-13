public class ThongBaoHR implements QuanSat {
    @Override
    public void capNhat(String thongBao, NV nv) {
        System.out.println("Phòng nhân sự nhận thông báo: " + thongBao + " - " + nv);
    }
}
