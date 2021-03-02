package com.tencent.mm.plugin.vlog.model.panel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import java.util.List;
import kotlin.a.j;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u001a\b\u0010\f\u001a\u00020\rH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001XD¢\u0006\u0002\n\u0000\"\u0014\u0010\u0002\u001a\u00020\u0001XD¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004\"\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006X\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u0007\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\"\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, hxF = {"TAG", "", "pagGroupId", "getPagGroupId", "()Ljava/lang/String;", "pagIconList", "", "pagItemType", "", "getPagItemType", "()I", "pagList", "createPagGroupInfo", "Lcom/tencent/mm/storage/emotion/EmojiGroupInfo;", "plugin-vlog_release"})
public final class b {
    private static final int GAQ = 108;
    private static final String GAR = GAR;
    private static final List<String> GAS = j.listOf((Object[]) new String[]{"2020051501 (0-00-01-00).png", "2020051502 (0-00-01-18).png", "2020051503 (0-00-01-05).png", "2020051504 (0-00-01-24).png", "2020051901 (0-00-01-13).png", "2020051902 (0-00-01-13).png", "2020051903 (0-00-01-03).png", "2020051904 (0-00-01-14).png", "2020051905 (0-00-00-25).png", "2020051906 (0-00-01-12).png", "2020051907 (0-00-01-18).png", "2020052001 (0-00-01-18).png", "2020052002 (0-00-01-00).png", "2020052003 (0-00-00-24).png", "2020052004 (0-00-00-14).png", "2020052005 (0-00-01-06).png", "2020052006 (0-00-00-25).png", "2020052007 (0-00-00-16).png"});
    private static final List<String> GAT = j.listOf((Object[]) new String[]{"2020051501.pag", "2020051502.pag", "2020051503.pag", "2020051504.pag", "2020051901.pag", "2020051902.pag", "2020051903.pag", "2020051904.pag", "2020051905.pag", "2020051906.pag", "2020051907.pag", "2020052001.pag", "2020052002.pag", "2020052003.pag", "2020052004.pag", "2020052005.pag", "2020052006.pag", "2020052007.pag"});
    private static final String TAG = TAG;

    static {
        AppMethodBeat.i(190785);
        AppMethodBeat.o(190785);
    }

    public static final int fCc() {
        return GAQ;
    }

    public static final String fCd() {
        return GAR;
    }

    public static final /* synthetic */ EmojiGroupInfo fCe() {
        AppMethodBeat.i(190786);
        EmojiGroupInfo emojiGroupInfo = new EmojiGroupInfo();
        emojiGroupInfo.setProductID(GAR);
        AppMethodBeat.o(190786);
        return emojiGroupInfo;
    }
}
