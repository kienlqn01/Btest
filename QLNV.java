import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class QLNV {
    private static QLNV instance;
    private HashMap<String, NV> dsNV;
    private List<QuanSat> dsQS;

    private QLNV() {
        dsNV = new HashMap<>();
        dsQS = new ArrayList<>();
    }

    public static QLNV getInstance() {
        if (instance == null) {
            instance = new QLNV();
        }
        return instance;
    }

    public void themNhanVien(NV nv) {
        dsNV.put(nv.getMaNV(), nv);
        for (QuanSat qs : dsQS) {
            if (nv.getCachTra().equals("duAn") && qs instanceof ThongBaoPM) {
                qs.capNhat("Nhân viên mới trong dự án", nv);
            } else if (nv.getCachTra().equals("ngay") && qs instanceof ThongBaoHR) {
                qs.capNhat("Nhân viên mới theo ngày công", nv);
            }
        }
    }

    public void themQuanSat(QuanSat qs) {
        dsQS.add(qs);
    }
}
