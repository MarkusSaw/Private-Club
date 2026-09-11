package privateclub.mapper;

import privateclub.dto.QrcodesDto;
import privateclub.model.Qrcodes;

import java.util.ArrayList;
import java.util.List;

public class QrcodesMapper {
    public static QrcodesDto toQrDto(Qrcodes qrd){
        return new QrcodesDto(
                qrd.getId(),
                qrd.getCodes()
        );
    }

    public static Qrcodes toQrEntity(QrcodesDto qdd){
        Qrcodes qr = new Qrcodes();
        qr.setId(qdd.id());
        qr.setCodes(qdd.codes());
        return qr;
    }

    public static List<QrcodesDto> listQrDto(List<Qrcodes> lqd) {
        List<QrcodesDto> result = new ArrayList<>();
        for (Qrcodes qr : lqd) {
            result.add(QrcodesMapper.toQrDto(qr));
        }
        return result;
    }

    public static List<Qrcodes> listToEntity(List<QrcodesDto> dtoList){
        List<Qrcodes> result = new ArrayList<>();
        for(QrcodesDto qdd : dtoList){
            result.add(QrcodesMapper.toQrEntity(qdd));
        }
        return result;
    }


}
