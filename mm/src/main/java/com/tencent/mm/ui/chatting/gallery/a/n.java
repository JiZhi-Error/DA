package com.tencent.mm.ui.chatting.gallery.a;

import android.graphics.PointF;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 62\u00020\u0001:\u000256B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u00100\u001a\u0002012\u0006\u00102\u001a\u000203J\u0006\u00104\u001a\u000201R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R\u001a\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\f\"\u0004\b \u0010\u000eR\u001c\u0010!\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\f\"\u0004\b#\u0010\u000eR\u001a\u0010$\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\f\"\u0004\b&\u0010\u000eR\u001a\u0010'\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0012\"\u0004\b)\u0010\u0014R\u001c\u0010*\u001a\u0004\u0018\u00010+X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/¨\u00067"}, hxF = {"Lcom/tencent/mm/ui/chatting/gallery/scan/ScanCodeResult;", "", "()V", "codePointInfo", "Lcom/tencent/mm/ui/chatting/gallery/scan/ScanCodeResult$CodePointInfo;", "getCodePointInfo", "()Lcom/tencent/mm/ui/chatting/gallery/scan/ScanCodeResult$CodePointInfo;", "setCodePointInfo", "(Lcom/tencent/mm/ui/chatting/gallery/scan/ScanCodeResult$CodePointInfo;)V", "codeString", "", "getCodeString", "()Ljava/lang/String;", "setCodeString", "(Ljava/lang/String;)V", "codeType", "", "getCodeType", "()I", "setCodeType", "(I)V", "codeVersion", "getCodeVersion", "setCodeVersion", "fromScanCodeButton", "", "getFromScanCodeButton", "()Z", "setFromScanCodeButton", "(Z)V", "imageKey", "getImageKey", "setImageKey", "imagePath", "getImagePath", "setImagePath", "source", "getSource", "setSource", "sourceType", "getSourceType", "setSourceType", "statObj", "Landroid/os/Bundle;", "getStatObj", "()Landroid/os/Bundle;", "setStatObj", "(Landroid/os/Bundle;)V", "convertFrom", "", "event", "Lcom/tencent/mm/autogen/events/RecogQBarOfImageFileResultEvent;", "reset", "CodePointInfo", "Companion", "app_release"})
public final class n {
    public static final b PDe = new b((byte) 0);
    public String CFJ;
    public a PDc;
    public boolean PDd;
    public int dFL;
    public int dFM;
    public String dFO = "";
    public Bundle dFP;
    public String imagePath = "";
    public String source = "";
    public int sourceType;

    static {
        AppMethodBeat.i(231308);
        AppMethodBeat.o(231308);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/ui/chatting/gallery/scan/ScanCodeResult$Companion;", "", "()V", "TAG", "", "app_release"})
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(byte b2) {
            this();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000e¨\u0006\u0014"}, hxF = {"Lcom/tencent/mm/ui/chatting/gallery/scan/ScanCodeResult$CodePointInfo;", "", "()V", "codePoint", "Landroid/graphics/PointF;", "getCodePoint", "()Landroid/graphics/PointF;", "setCodePoint", "(Landroid/graphics/PointF;)V", "decodeImageHeight", "", "getDecodeImageHeight", "()I", "setDecodeImageHeight", "(I)V", "decodeImageWidth", "getDecodeImageWidth", "setDecodeImageWidth", "toString", "", "app_release"})
    public static final class a {
        public PointF PDf;
        public int PDg;
        public int PDh;

        public final String toString() {
            AppMethodBeat.i(231307);
            String str = "codePoint: " + this.PDf + ", imageWidth: " + this.PDg + ", imageHeight: " + this.PDh;
            AppMethodBeat.o(231307);
            return str;
        }
    }
}
