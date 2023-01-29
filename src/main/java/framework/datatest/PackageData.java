package framework.datatest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PackageData {
    List<String> listBank1 = Arrays.asList("ВТБ", "Тинькофф", "Сбербанк", "Газпромбанк");
    List<String> listParameters1 = Arrays.asList("Со снятием", "С пополнением", "С капитализацией");
    Data pack1 = new Data("1000000","6 месяцев","Обычные вклады",
            listBank1,listParameters1,"14", "Тинькофф", "5,63",
            "182","27741");

    List<String> listBank2 = Arrays.asList("Ак Барс", "РОССИЯ", "Сбербанк");
    List<String> listParameters2 = Arrays.asList("С выплатой процентов");

    Data pack2 = new Data("500000","2 года","Детский",
            listBank2,listParameters2,"7", "Сбербанк", "6,80",
            "730","72514");

    public Data getPack1() {
        return pack1;
    }

    public void setPack1(Data pack1) {
        this.pack1 = pack1;
    }

    public Data getPack2() {
        return pack2;
    }

    public void setPack2(Data pack2) {
        this.pack2 = pack2;
    }
}
