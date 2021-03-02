package com.tencent.mm.picker.e;

import com.tencent.mm.R;
import com.tencent.qqmusic.mediaplayer.PlayerException;

public final class a {
    public static int I(int i2, boolean z) {
        switch (i2) {
            case PlayerException.EXCEPTION_TYPE_CONNECT_FAIL /*{ENCODED_INT: 80}*/:
                return z ? R.anim.d_ : R.anim.da;
            default:
                return -1;
        }
    }
}
