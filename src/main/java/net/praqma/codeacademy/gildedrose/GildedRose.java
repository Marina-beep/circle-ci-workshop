package net.praqma.codeacademy.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    private int degradeVelocity(int speed, int direction) {
        return speed * direction;
    }

    public void updateQuality() {
        for (Item item : items) {
            int degradeSpeed = 1;
            boolean isDegradable = true;
            int degradeDirection = 1;

            if (item.name.equals("Conjured")) {
                degradeSpeed *= 2;
            }

            if (item.name.equals("Aged Brie") || item.name.equals("Backstage passes")) {
                degradeDirection = -1;
            }

            if (item.name.equals("Sulfuras")) {
                isDegradable = false;
                degradeSpeed = 0;
            }

            if (isDegradable) {
                item.sellIn--;
                item.quality -= degradeVelocity(degradeSpeed, degradeDirection);
            }

            if (item.quality < 0) {
                item.quality = 0;
            } else if (item.quality > 50) {
                item.quality = 50;
            }

        }
    }
}
