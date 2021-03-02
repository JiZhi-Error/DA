package com.bumptech.glide;

import com.bumptech.glide.e.b.a;
import com.bumptech.glide.e.b.c;
import com.bumptech.glide.k;

public abstract class k<CHILD extends k<CHILD, TranscodeType>, TranscodeType> implements Cloneable {
    c<? super TranscodeType> aDA = a.qo();

    /* renamed from: nV */
    public final CHILD clone() {
        try {
            return (CHILD) ((k) super.clone());
        } catch (CloneNotSupportedException e2) {
            throw new RuntimeException(e2);
        }
    }
}
