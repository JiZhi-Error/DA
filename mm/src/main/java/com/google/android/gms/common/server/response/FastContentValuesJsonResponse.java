package com.google.android.gms.common.server.response;

import android.content.ContentValues;
import com.google.android.gms.common.util.VisibleForTesting;

public abstract class FastContentValuesJsonResponse extends FastJsonResponse {
    private final ContentValues zzwj;

    public FastContentValuesJsonResponse() {
        this.zzwj = new ContentValues();
    }

    @VisibleForTesting
    public FastContentValuesJsonResponse(ContentValues contentValues) {
        this.zzwj = contentValues;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public Object getValueObject(String str) {
        return this.zzwj.get(str);
    }

    public ContentValues getValues() {
        return this.zzwj;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public boolean isPrimitiveFieldSet(String str) {
        return this.zzwj.containsKey(str);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public void setBoolean(String str, boolean z) {
        this.zzwj.put(str, Boolean.valueOf(z));
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public void setDecodedBytes(String str, byte[] bArr) {
        this.zzwj.put(str, bArr);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public void setDouble(String str, double d2) {
        this.zzwj.put(str, Double.valueOf(d2));
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public void setFloat(String str, float f2) {
        this.zzwj.put(str, Float.valueOf(f2));
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public void setInteger(String str, int i2) {
        this.zzwj.put(str, Integer.valueOf(i2));
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public void setLong(String str, long j2) {
        this.zzwj.put(str, Long.valueOf(j2));
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public void setString(String str, String str2) {
        this.zzwj.put(str, str2);
    }
}
