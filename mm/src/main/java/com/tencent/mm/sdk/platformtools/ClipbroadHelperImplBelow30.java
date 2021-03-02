package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.ClipboardManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;

/* access modifiers changed from: package-private */
public class ClipbroadHelperImplBelow30 implements ClipboardHelper.IClipboard {
    ClipbroadHelperImplBelow30() {
    }

    @Override // com.tencent.mm.sdk.platformtools.ClipboardHelper.IClipboard
    public void setText(Context context, CharSequence charSequence, CharSequence charSequence2) {
        AppMethodBeat.i(215360);
        ((ClipboardManager) MMApplicationContext.getContext().getSystemService("clipboard")).setText(charSequence2);
        AppMethodBeat.o(215360);
    }

    @Override // com.tencent.mm.sdk.platformtools.ClipboardHelper.IClipboard
    public CharSequence getText(Context context) {
        AppMethodBeat.i(215361);
        CharSequence text = ((ClipboardManager) MMApplicationContext.getContext().getSystemService("clipboard")).getText();
        AppMethodBeat.o(215361);
        return text;
    }

    @Override // com.tencent.mm.sdk.platformtools.ClipboardHelper.IClipboard
    public void setIntent(Context context, CharSequence charSequence, Intent intent) {
    }

    @Override // com.tencent.mm.sdk.platformtools.ClipboardHelper.IClipboard
    public Intent getIntent(Context context) {
        return null;
    }

    @Override // com.tencent.mm.sdk.platformtools.ClipboardHelper.IClipboard
    public void setUri(Context context, CharSequence charSequence, Uri uri) {
    }

    @Override // com.tencent.mm.sdk.platformtools.ClipboardHelper.IClipboard
    public Uri getUri(Context context) {
        return null;
    }
}
