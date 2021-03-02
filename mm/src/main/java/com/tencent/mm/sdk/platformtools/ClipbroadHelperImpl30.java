package com.tencent.mm.sdk.platformtools;

import android.annotation.TargetApi;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;

/* access modifiers changed from: package-private */
public class ClipbroadHelperImpl30 implements ClipboardHelper.IClipboard {
    ClipbroadHelperImpl30() {
    }

    @Override // com.tencent.mm.sdk.platformtools.ClipboardHelper.IClipboard
    @TargetApi(11)
    public void setText(Context context, CharSequence charSequence, CharSequence charSequence2) {
        AppMethodBeat.i(215354);
        ((ClipboardManager) MMApplicationContext.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(charSequence, charSequence2));
        AppMethodBeat.o(215354);
    }

    @Override // com.tencent.mm.sdk.platformtools.ClipboardHelper.IClipboard
    @TargetApi(11)
    public CharSequence getText(Context context) {
        AppMethodBeat.i(215355);
        ClipData primaryClip = ((ClipboardManager) MMApplicationContext.getContext().getSystemService("clipboard")).getPrimaryClip();
        if (primaryClip == null || primaryClip.getItemCount() <= 0) {
            AppMethodBeat.o(215355);
            return null;
        }
        ClipData.Item itemAt = primaryClip.getItemAt(0);
        if (itemAt == null) {
            AppMethodBeat.o(215355);
            return null;
        }
        CharSequence text = itemAt.getText();
        AppMethodBeat.o(215355);
        return text;
    }

    @Override // com.tencent.mm.sdk.platformtools.ClipboardHelper.IClipboard
    @TargetApi(11)
    public void setIntent(Context context, CharSequence charSequence, Intent intent) {
        AppMethodBeat.i(215356);
        ((ClipboardManager) MMApplicationContext.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newIntent(charSequence, intent));
        AppMethodBeat.o(215356);
    }

    @Override // com.tencent.mm.sdk.platformtools.ClipboardHelper.IClipboard
    @TargetApi(11)
    public Intent getIntent(Context context) {
        AppMethodBeat.i(215357);
        ClipData primaryClip = ((ClipboardManager) MMApplicationContext.getContext().getSystemService("clipboard")).getPrimaryClip();
        if (primaryClip == null || primaryClip.getItemCount() <= 0) {
            AppMethodBeat.o(215357);
            return null;
        }
        ClipData.Item itemAt = primaryClip.getItemAt(0);
        if (itemAt == null) {
            AppMethodBeat.o(215357);
            return null;
        }
        Intent intent = itemAt.getIntent();
        AppMethodBeat.o(215357);
        return intent;
    }

    @Override // com.tencent.mm.sdk.platformtools.ClipboardHelper.IClipboard
    @TargetApi(11)
    public void setUri(Context context, CharSequence charSequence, Uri uri) {
        AppMethodBeat.i(215358);
        ((ClipboardManager) MMApplicationContext.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newRawUri(charSequence, uri));
        AppMethodBeat.o(215358);
    }

    @Override // com.tencent.mm.sdk.platformtools.ClipboardHelper.IClipboard
    @TargetApi(11)
    public Uri getUri(Context context) {
        AppMethodBeat.i(215359);
        ClipData primaryClip = ((ClipboardManager) MMApplicationContext.getContext().getSystemService("clipboard")).getPrimaryClip();
        if (primaryClip == null || primaryClip.getItemCount() <= 0) {
            AppMethodBeat.o(215359);
            return null;
        }
        ClipData.Item itemAt = primaryClip.getItemAt(0);
        if (itemAt == null) {
            AppMethodBeat.o(215359);
            return null;
        }
        Uri uri = itemAt.getUri();
        AppMethodBeat.o(215359);
        return uri;
    }
}
