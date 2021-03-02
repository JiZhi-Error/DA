package com.tencent.map.lib.models;

import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;

@Keep
public enum DataSource {
    NONE(-1),
    SATELLITE(0),
    MAP(1),
    STREET_VIEW_ROAD(2),
    TRAFFIC_NETWORK(3),
    INDOOR_BUILDINGS(4),
    LANDMARK(5),
    TILE_OVERLAY(6),
    INDOOR_CONFIG(7),
    NUM(8);
    
    private final int mValue;

    public static DataSource valueOf(String str) {
        AppMethodBeat.i(180730);
        DataSource dataSource = (DataSource) Enum.valueOf(DataSource.class, str);
        AppMethodBeat.o(180730);
        return dataSource;
    }

    static {
        AppMethodBeat.i(180732);
        AppMethodBeat.o(180732);
    }

    private DataSource(int i2) {
        this.mValue = i2;
    }

    public static DataSource get(int i2) {
        AppMethodBeat.i(180731);
        DataSource[] values = values();
        for (DataSource dataSource : values) {
            if (dataSource.mValue == i2) {
                AppMethodBeat.o(180731);
                return dataSource;
            }
        }
        DataSource dataSource2 = NONE;
        AppMethodBeat.o(180731);
        return dataSource2;
    }

    public final int getValue() {
        return this.mValue;
    }
}
