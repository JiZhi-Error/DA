package com.google.android.gms.common.data;

import android.content.ContentValues;
import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class TransientDataHolder {
    private String zzos;
    private String zzot;
    private DataHolder.Builder zzou;

    public TransientDataHolder(String[] strArr) {
        this(strArr, null, null, null);
    }

    public TransientDataHolder(String[] strArr, String str, String str2, String str3) {
        AppMethodBeat.i(11679);
        this.zzos = str2;
        this.zzot = str3;
        if (str != null) {
            this.zzou = DataHolder.builder(strArr, str);
            AppMethodBeat.o(11679);
            return;
        }
        this.zzou = DataHolder.builder(strArr);
        AppMethodBeat.o(11679);
    }

    public final void addRow(ContentValues contentValues) {
        AppMethodBeat.i(11680);
        this.zzou.withRow(contentValues);
        AppMethodBeat.o(11680);
    }

    @VisibleForTesting
    public final DataHolder build(int i2) {
        AppMethodBeat.i(11687);
        DataHolder build = build(i2, new Bundle(), -1);
        AppMethodBeat.o(11687);
        return build;
    }

    public final DataHolder build(int i2, Bundle bundle, int i3) {
        AppMethodBeat.i(11688);
        bundle.putString(DataBufferUtils.KEY_NEXT_PAGE_TOKEN, this.zzot);
        bundle.putString(DataBufferUtils.KEY_PREV_PAGE_TOKEN, this.zzos);
        DataHolder build = this.zzou.build(i2, bundle, i3);
        AppMethodBeat.o(11688);
        return build;
    }

    public final boolean containsRowWithValue(String str, Object obj) {
        AppMethodBeat.i(11681);
        boolean containsRowWithValue = this.zzou.containsRowWithValue(str, obj);
        AppMethodBeat.o(11681);
        return containsRowWithValue;
    }

    public final int getCount() {
        AppMethodBeat.i(11684);
        int count = this.zzou.getCount();
        AppMethodBeat.o(11684);
        return count;
    }

    public final String getNextToken() {
        return this.zzot;
    }

    public final String getPrevToken() {
        return this.zzos;
    }

    public final void modifyUniqueRowValue(Object obj, String str, Object obj2) {
        AppMethodBeat.i(11682);
        this.zzou.modifyUniqueRowValue(obj, str, obj2);
        AppMethodBeat.o(11682);
    }

    @VisibleForTesting
    public final void removeRows(String str, Object obj) {
        AppMethodBeat.i(11683);
        this.zzou.removeRowsWithValue(str, obj);
        AppMethodBeat.o(11683);
    }

    public final void setNextToken(String str) {
        this.zzot = str;
    }

    public final void setPrevToken(String str) {
        this.zzos = str;
    }

    public final void sortData(String str) {
        AppMethodBeat.i(11685);
        this.zzou.sort(str);
        AppMethodBeat.o(11685);
    }

    public final void sortDataDescending(String str) {
        AppMethodBeat.i(11686);
        this.zzou.descendingSort(str);
        AppMethodBeat.o(11686);
    }
}
