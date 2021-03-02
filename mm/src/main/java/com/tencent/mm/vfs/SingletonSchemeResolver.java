package com.tencent.mm.vfs;

import android.os.Parcel;
import com.tencent.mm.vfs.SchemeResolver;

public abstract class SingletonSchemeResolver implements SchemeResolver, SchemeResolver.a {
    @Override // com.tencent.mm.vfs.SchemeResolver
    public final SchemeResolver.a hel() {
        return this;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
    }

    @Override // com.tencent.mm.vfs.SchemeResolver.a
    public final SchemeResolver hem() {
        return this;
    }
}
