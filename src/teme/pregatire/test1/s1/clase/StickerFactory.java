package teme.pregatire.test1.s1.clase;

import java.util.HashMap;
import java.util.Map;

public class StickerFactory {
    private Map<String, Sticker> stickers = new HashMap<>();

    public Sticker getStickerforMasina(Masina masina) throws CloneNotSupportedException {
        if (!stickers.containsKey(masina.getModelMasina() + masina.getAnFabricatie())) {
            stickers.put(masina.getModelMasina() + masina.getAnFabricatie(), new Sticker(new Masina("Skoda", 2003)));
        }
        return stickers.get(masina.getModelMasina() + masina.getAnFabricatie()).clone();
    }
}
