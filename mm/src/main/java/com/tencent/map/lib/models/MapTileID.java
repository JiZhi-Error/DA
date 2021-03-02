package com.tencent.map.lib.models;

import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;

@Keep
public class MapTileID {
    private int dataSource;
    private int priority;
    private int tileTag;
    private String url;
    private int x;
    private int y;
    private int z;

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getZ() {
        return this.z;
    }

    public String getUrl() {
        return this.url;
    }

    public DownloadPriority getPriority() {
        AppMethodBeat.i(180747);
        DownloadPriority downloadPriority = DownloadPriority.get(this.priority);
        AppMethodBeat.o(180747);
        return downloadPriority;
    }

    public DataSource getDataSource() {
        AppMethodBeat.i(180748);
        DataSource dataSource2 = DataSource.get(this.dataSource);
        AppMethodBeat.o(180748);
        return dataSource2;
    }

    public int getTileTag() {
        return this.tileTag;
    }

    public String toString() {
        AppMethodBeat.i(180749);
        String str = "MapTileID{x=" + this.x + ", y=" + this.y + ", z=" + this.z + ", url='" + this.url + '\'' + ", priority=" + this.priority + ", dataSource=" + this.dataSource + ", tileTag=" + this.tileTag + '}';
        AppMethodBeat.o(180749);
        return str;
    }
}
