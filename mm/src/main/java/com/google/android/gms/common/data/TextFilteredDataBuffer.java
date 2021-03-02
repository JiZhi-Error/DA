package com.google.android.gms.common.data;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.common.data.TextFilterable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Locale;

public final class TextFilteredDataBuffer<T> extends FilteredDataBuffer<T> implements TextFilterable {
    private final ArrayList<Integer> zzob = new ArrayList<>();
    private AbstractDataBuffer<T> zzoc;
    private final String zzoo;
    private String zzop;
    private TextFilterable.StringFilter zzoq;
    private Locale zzor;

    public TextFilteredDataBuffer(AbstractDataBuffer<T> abstractDataBuffer, String str) {
        super(abstractDataBuffer);
        AppMethodBeat.i(11673);
        this.zzoc = abstractDataBuffer;
        this.zzoo = str;
        AppMethodBeat.o(11673);
    }

    private final String zzh(String str) {
        AppMethodBeat.i(11678);
        String lowerCase = str.toLowerCase(this.zzor);
        StringBuilder sb = new StringBuilder();
        int length = lowerCase.length();
        for (int i2 = 0; i2 < length; i2++) {
            if (!Character.isIdentifierIgnorable(lowerCase.charAt(i2))) {
                sb.append(lowerCase.charAt(i2));
            }
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(11678);
        return sb2;
    }

    @Override // com.google.android.gms.common.data.FilteredDataBuffer
    public final int computeRealPosition(int i2) {
        AppMethodBeat.i(11675);
        if (TextUtils.isEmpty(this.zzop)) {
            AppMethodBeat.o(11675);
            return i2;
        } else if (i2 < 0 || i2 >= this.zzob.size()) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(new StringBuilder(53).append("Position ").append(i2).append(" is out of bounds for this buffer").toString());
            AppMethodBeat.o(11675);
            throw illegalArgumentException;
        } else {
            int intValue = this.zzob.get(i2).intValue();
            AppMethodBeat.o(11675);
            return intValue;
        }
    }

    @Override // com.google.android.gms.common.data.DataBuffer
    public final int getCount() {
        AppMethodBeat.i(11674);
        if (TextUtils.isEmpty(this.zzop)) {
            int count = this.mDataBuffer.getCount();
            AppMethodBeat.o(11674);
            return count;
        }
        int size = this.zzob.size();
        AppMethodBeat.o(11674);
        return size;
    }

    @Override // com.google.android.gms.common.data.TextFilterable
    public final void setFilterTerm(Context context, TextFilterable.StringFilter stringFilter, String str) {
        AppMethodBeat.i(11677);
        Preconditions.checkNotNull(stringFilter);
        this.zzop = str;
        this.zzoq = stringFilter;
        if (!TextUtils.isEmpty(this.zzop)) {
            this.zzor = context.getResources().getConfiguration().locale;
            this.zzop = zzh(this.zzop);
            this.zzob.clear();
            DataHolder dataHolder = this.zzoc.mDataHolder;
            String str2 = this.zzoo;
            boolean z = this.zzoc instanceof EntityBuffer;
            int count = this.zzoc.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                int zzi = z ? ((EntityBuffer) this.zzoc).zzi(i2) : i2;
                String string = dataHolder.getString(str2, zzi, dataHolder.getWindowIndex(zzi));
                if (!TextUtils.isEmpty(string) && this.zzoq.matches(zzh(string), this.zzop)) {
                    this.zzob.add(Integer.valueOf(i2));
                }
            }
            AppMethodBeat.o(11677);
            return;
        }
        this.zzob.clear();
        AppMethodBeat.o(11677);
    }

    @Override // com.google.android.gms.common.data.TextFilterable
    @VisibleForTesting
    public final void setFilterTerm(Context context, String str) {
        AppMethodBeat.i(11676);
        setFilterTerm(context, CONTAINS, str);
        AppMethodBeat.o(11676);
    }
}
