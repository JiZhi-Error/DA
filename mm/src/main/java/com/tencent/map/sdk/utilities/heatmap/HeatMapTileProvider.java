package com.tencent.map.sdk.utilities.heatmap;

import android.graphics.Color;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.TileProvider;
import java.util.ArrayList;
import java.util.Collection;

public abstract class HeatMapTileProvider implements TileProvider {
    public static final Gradient DEFAULT_GRADIENT = new Gradient(DEFAULT_GRADIENT_COLORS, DEFAULT_GRADIENT_START_POINTS);
    private static final int[] DEFAULT_GRADIENT_COLORS = {Color.argb(0, 25, 0, 255), Color.argb((int) TbsListener.ErrorCode.NEEDDOWNLOAD_TRUE, 30, 0, 255), Color.rgb(0, 191, 255), Color.rgb(0, 255, 0), Color.rgb(255, 255, 0), Color.rgb(255, 0, 0)};
    private static final float[] DEFAULT_GRADIENT_START_POINTS = {0.0f, 0.4f, 0.6f, 0.75f, 0.8f, 1.0f};
    public static final double DEFAULT_OPACITY = 0.6d;
    public static final int DEFAULT_RADIUS = 40;
    private static final int MAX_RADIUS = 50;
    private static final int MIN_RADIUS = 10;
    static final double WORLD_WIDTH = 1.0d;

    public interface HeatTileGenerator {
        int[] generateColorMap(double d2);

        double[] generateKernel(int i2);
    }

    public interface OnHeatMapReadyListener {
        void onHeatMapReady();
    }

    public abstract void setData(Collection<LatLng> collection);

    public abstract void setGradient(Gradient gradient);

    public abstract void setHeatTileGenerator(HeatTileGenerator heatTileGenerator);

    public abstract void setOpacity(double d2);

    public abstract void setRadius(int i2);

    public abstract void setWeightedData(Collection<WeightedLatLng> collection);

    public static class Builder {
        private Collection<WeightedLatLng> data;
        private Gradient gradient = HeatMapTileProvider.DEFAULT_GRADIENT;
        private HeatTileGenerator heatTileGenerator;
        private double opacity = 0.6d;
        private int radius = 40;
        private OnHeatMapReadyListener readyListener;

        public Builder data(Collection<LatLng> collection) {
            AppMethodBeat.i(84375);
            Builder weightedData = weightedData(HeatMapTileProvider.wrapData(collection));
            AppMethodBeat.o(84375);
            return weightedData;
        }

        public Builder weightedData(Collection<WeightedLatLng> collection) {
            AppMethodBeat.i(84376);
            if (collection.isEmpty()) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("No input points.");
                AppMethodBeat.o(84376);
                throw illegalArgumentException;
            }
            this.data = collection;
            AppMethodBeat.o(84376);
            return this;
        }

        public Builder gradient(Gradient gradient2) {
            this.gradient = gradient2;
            return this;
        }

        public Builder opacity(double d2) {
            AppMethodBeat.i(84377);
            if (d2 < 0.0d || d2 > HeatMapTileProvider.WORLD_WIDTH) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Opacity must be in range [0, 1]");
                AppMethodBeat.o(84377);
                throw illegalArgumentException;
            }
            this.opacity = d2;
            AppMethodBeat.o(84377);
            return this;
        }

        public Builder radius(int i2) {
            AppMethodBeat.i(84378);
            if (i2 < 10 || i2 > 50) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Radius not within bounds.");
                AppMethodBeat.o(84378);
                throw illegalArgumentException;
            }
            this.radius = i2;
            AppMethodBeat.o(84378);
            return this;
        }

        public Builder tileGenerator(HeatTileGenerator heatTileGenerator2) {
            this.heatTileGenerator = heatTileGenerator2;
            return this;
        }

        public Builder readyListener(OnHeatMapReadyListener onHeatMapReadyListener) {
            this.readyListener = onHeatMapReadyListener;
            return this;
        }

        public Collection<WeightedLatLng> getData() {
            return this.data;
        }

        public int getRadius() {
            return this.radius;
        }

        public Gradient getGradient() {
            return this.gradient;
        }

        public double getOpacity() {
            return this.opacity;
        }

        public HeatTileGenerator getHeatTileGenerator() {
            return this.heatTileGenerator;
        }

        public OnHeatMapReadyListener getReadyListener() {
            return this.readyListener;
        }

        public HeatMapTileProvider build(TencentMap tencentMap) {
            AppMethodBeat.i(180752);
            if (tencentMap != null) {
                HeatMapTileProvider createHeatMapTileProvider = tencentMap.getMapContext().createHeatMapTileProvider(this);
                AppMethodBeat.o(180752);
                return createHeatMapTileProvider;
            }
            AppMethodBeat.o(180752);
            return null;
        }
    }

    /* access modifiers changed from: private */
    public static Collection<WeightedLatLng> wrapData(Collection<LatLng> collection) {
        ArrayList arrayList = new ArrayList();
        for (LatLng latLng : collection) {
            arrayList.add(new WeightedLatLng(latLng));
        }
        return arrayList;
    }
}
