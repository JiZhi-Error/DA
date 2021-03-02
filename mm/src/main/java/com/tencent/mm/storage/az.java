package com.tencent.mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.o.a;

public final class az extends a implements com.tencent.mm.storagebase.a.a<String> {
    public ca OoM;

    public az(String str) {
        super(str);
    }

    public az() {
    }

    @Override // com.tencent.mm.g.c.bb
    public final void yB(long j2) {
        AppMethodBeat.i(160771);
        super.yB(j2);
        AppMethodBeat.o(160771);
    }

    @Override // com.tencent.mm.g.c.bb, com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public final ContentValues convertTo() {
        AppMethodBeat.i(160772);
        ContentValues convertTo = super.convertTo();
        AppMethodBeat.o(160772);
        return convertTo;
    }

    @Override // com.tencent.mm.g.c.bb, com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public final void convertFrom(Cursor cursor) {
        AppMethodBeat.i(160773);
        super.convertFrom(cursor);
        AppMethodBeat.o(160773);
    }

    public final void gCr() {
        AppMethodBeat.i(43192);
        setStatus(0);
        nv(0);
        setContent("");
        Cl(AppEventsConstants.EVENT_PARAM_VALUE_NO);
        nt(0);
        nB(0);
        yC(0);
        nA(0);
        nA(0);
        super.Cm("");
        super.Cn("");
        AppMethodBeat.o(43192);
    }

    @Override // com.tencent.mm.storagebase.a.a
    public final void t(int i2, byte[] bArr) {
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.storagebase.a.a
    public final void dh(int i2, String str) {
        AppMethodBeat.i(43194);
        switch (i2) {
            case 4:
                setUsername(str);
                AppMethodBeat.o(43194);
                return;
            case 5:
                setContent(str);
                AppMethodBeat.o(43194);
                return;
            case 6:
                Cl(str);
                AppMethodBeat.o(43194);
                return;
            case 8:
                Cm(str);
                AppMethodBeat.o(43194);
                return;
            case 9:
                Cn(str);
                AppMethodBeat.o(43194);
                return;
            case 11:
                Cp(str);
                break;
        }
        AppMethodBeat.o(43194);
    }

    @Override // com.tencent.mm.storagebase.a.a
    public final void gzB() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:6:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void aX(com.tencent.mm.storage.ca r9) {
        /*
        // Method dump skipped, instructions count: 187
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.storage.az.aX(com.tencent.mm.storage.ca):void");
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.storagebase.a.a
    public final void aT(int i2, long j2) {
        AppMethodBeat.i(43193);
        switch (i2) {
            case 0:
                nt((int) j2);
                AppMethodBeat.o(43193);
                return;
            case 1:
                setStatus((int) j2);
                AppMethodBeat.o(43193);
                return;
            case 2:
                nv((int) j2);
                AppMethodBeat.o(43193);
                return;
            case 3:
                yA(j2);
                AppMethodBeat.o(43193);
                return;
            case 7:
                super.yB(j2);
                AppMethodBeat.o(43193);
                return;
            case 10:
                nx((int) j2);
                AppMethodBeat.o(43193);
                return;
            case 12:
                ny((int) j2);
                AppMethodBeat.o(43193);
                return;
            case 13:
                nz((int) j2);
                AppMethodBeat.o(43193);
                return;
            case 14:
                nB((int) j2);
                AppMethodBeat.o(43193);
                return;
            case 16:
                nD((int) j2);
                break;
        }
        AppMethodBeat.o(43193);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.tencent.mm.storagebase.a.a
    public final /* bridge */ /* synthetic */ String getKey() {
        return this.field_username;
    }
}
