package com.tencent.tencentmap.mapsdk.maps.model;

import com.tencent.map.tools.net.NetManager;
import com.tencent.map.tools.net.NetResponse;
import com.tencent.map.tools.net.exception.NetErrorException;
import java.net.URL;

public abstract class UrlTileProvider implements TileProvider {
    private final int mHeight;
    private final int mWidth;

    public abstract URL getTileUrl(int i2, int i3, int i4);

    public UrlTileProvider() {
        this(256, 256);
    }

    public UrlTileProvider(int i2, int i3) {
        this.mWidth = i2;
        this.mHeight = i3;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.TileProvider
    public final Tile getTile(int i2, int i3, int i4) {
        byte[] bArr = null;
        URL tileUrl = getTileUrl(i2, i3, i4);
        Tile tile = NO_TILE;
        if (tileUrl == null) {
            return tile;
        }
        NetResponse requestTileData = requestTileData(tileUrl.toString());
        if (requestTileData != null) {
            if (requestTileData.available()) {
                bArr = requestTileData.data;
            } else if (requestTileData.exception instanceof NetErrorException) {
                if (requestTileData.statusCode == 404) {
                    return NO_TILE;
                }
                return new Tile(this.mWidth, this.mHeight, null);
            }
        }
        if (bArr == null || bArr.length == 0) {
            return tile;
        }
        return new Tile(this.mWidth, this.mHeight, bArr);
    }

    /* access modifiers changed from: protected */
    public NetResponse requestTileData(String str) {
        try {
            return NetManager.getInstance().builder().url(str).doGet();
        } catch (Exception e2) {
            return null;
        }
    }
}
