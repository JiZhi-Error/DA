package com.tencent.mm.plugin.websearch.a.a;

import android.graphics.Bitmap;
import com.google.android.gms.actions.SearchIntents;
import com.tencent.mm.plugin.websearch.a.a;
import com.tencent.mm.plugin.websearch.a.d;
import com.tencent.mm.plugin.websearch.webview.c;
import com.tencent.mm.protocal.protobuf.buv;
import com.tencent.mm.protocal.protobuf.egj;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H&J\n\u0010\n\u001a\u0004\u0018\u00010\u000bH&J\n\u0010\f\u001a\u0004\u0018\u00010\rH&J$\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0006H&J\u0018\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0016H&J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0006H&J\u0010\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0002H&¨\u0006\u001b"}, hxF = {"Lcom/tencent/mm/plugin/websearch/tagsearch/ui/ITagSearchUIComponent;", "Lcom/tencent/mm/plugin/websearch/webview/IWebSearchImageUIComponent;", "Lcom/tencent/mm/protocal/protobuf/TagSearchHomeContext;", "appendSearchTag", "", "tag", "", "sessionId", "searchId", "requestId", "getWebSearchData", "Lcom/tencent/mm/plugin/websearch/tagsearch/TagSearchWebData;", "getWebSearchJSApi", "Lcom/tencent/mm/plugin/websearch/tagsearch/TagSearchJSApi;", "onEndSearchShareCgi", "shareContent", "Lcom/tencent/mm/protocal/protobuf/GetSearchShareResponse;", "cropBitmap", "Landroid/graphics/Bitmap;", SearchIntents.EXTRA_QUERY, "onSearchInputChange", "isInputChange", "", "onStartSearchShareCgi", "id", "startMoreTab", "moreContext", "ui-websearch_release"})
public interface b extends c<egj> {
    void F(String str, String str2, String str3, String str4);

    void a(buv buv, Bitmap bitmap, String str);

    void a(egj egj);

    void aXn(String str);

    void cK(String str, boolean z);

    d fYG();

    a fYH();
}
