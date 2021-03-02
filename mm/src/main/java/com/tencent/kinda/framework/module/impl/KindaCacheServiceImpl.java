package com.tencent.kinda.framework.module.impl;

import com.tencent.kinda.framework.app.KindaCacheItem;
import com.tencent.kinda.framework.app.SubCoreKinda;
import com.tencent.kinda.gen.KCacheService;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class KindaCacheServiceImpl implements KCacheService {
    @Override // com.tencent.kinda.gen.KCacheService
    public void set(String str, byte[] bArr, long j2) {
        AppMethodBeat.i(18625);
        KindaCacheItem kindaCacheItem = new KindaCacheItem();
        kindaCacheItem.field_key = str;
        kindaCacheItem.field_value = bArr;
        if (j2 == 0) {
            kindaCacheItem.field_expire_at = (System.currentTimeMillis() / 1000) + 315360000;
        } else {
            kindaCacheItem.field_expire_at = (System.currentTimeMillis() / 1000) + j2;
        }
        SubCoreKinda.getCore().getCacheStg().save(kindaCacheItem);
        AppMethodBeat.o(18625);
    }

    @Override // com.tencent.kinda.gen.KCacheService
    public byte[] get(String str) {
        AppMethodBeat.i(18626);
        KindaCacheItem kindaCacheItem = SubCoreKinda.getCore().getCacheStg().get(str);
        if (kindaCacheItem == null) {
            AppMethodBeat.o(18626);
            return null;
        } else if (kindaCacheItem.field_expire_at < System.currentTimeMillis() / 1000) {
            AppMethodBeat.o(18626);
            return null;
        } else {
            byte[] bArr = kindaCacheItem.field_value;
            AppMethodBeat.o(18626);
            return bArr;
        }
    }

    @Override // com.tencent.kinda.gen.KCacheService
    public boolean remove(String str) {
        AppMethodBeat.i(18627);
        KindaCacheItem kindaCacheItem = SubCoreKinda.getCore().getCacheStg().get(str);
        if (kindaCacheItem != null) {
            boolean delete = SubCoreKinda.getCore().getCacheStg().delete(kindaCacheItem, new String[0]);
            AppMethodBeat.o(18627);
            return delete;
        }
        AppMethodBeat.o(18627);
        return true;
    }

    @Override // com.tencent.kinda.gen.KCacheService
    public void setBool(String str, boolean z, long j2) {
        AppMethodBeat.i(18628);
        byte[] bArr = new byte[1];
        if (z) {
            bArr[0] = 1;
        }
        set(str, bArr, j2);
        AppMethodBeat.o(18628);
    }

    @Override // com.tencent.kinda.gen.KCacheService
    public boolean getBool(String str) {
        AppMethodBeat.i(18629);
        byte[] bArr = get(str);
        if (bArr == null || bArr.length <= 0 || bArr[0] != 1) {
            AppMethodBeat.o(18629);
            return false;
        }
        AppMethodBeat.o(18629);
        return true;
    }
}
