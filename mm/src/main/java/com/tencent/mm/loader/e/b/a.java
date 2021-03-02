package com.tencent.mm.loader.e.b;

import com.facebook.share.internal.ShareConstants;
import com.tencent.mm.loader.f;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u0011*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0001\u0011B\u0005¢\u0006\u0002\u0010\u0003J!\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00028\u00002\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\bH\u0014¢\u0006\u0002\u0010\tJ\b\u0010\n\u001a\u00020\u000bH\u0016J$\u0010\f\u001a\u00020\r2\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\b2\u000e\u0010\u000e\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u000fH\u0016J$\u0010\u0010\u001a\u00020\r2\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\b2\u000e\u0010\u000e\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u000fH\u0016¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/loader/impr/target/EmptyTarget;", "R", "Lcom/tencent/mm/loader/impr/target/ResourceShowTarget;", "()V", "onResourceReadyUI", "", "resource", "viewWeakHolder", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "(Ljava/lang/Object;Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;)Z", "uniqueCode", "", "updateBackgroundUI", "", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lcom/tencent/mm/loader/Reaper;", "updateDefaultDrawable", "Companion", "libimageloader_release"})
public final class a<R> extends d<R> {
    private static final String TAG = TAG;
    public static final C0402a ian = new C0402a((byte) 0);

    public a() {
        super(new g(null));
    }

    @Override // com.tencent.mm.loader.e.b.d
    public final int aJV() {
        return 0;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.loader.e.b.d
    public final boolean a(R r, g<?> gVar) {
        p.h(gVar, "viewWeakHolder");
        return true;
    }

    @Override // com.tencent.mm.loader.e.b.d
    public final void a(g<?> gVar, f<?, ?> fVar) {
        p.h(gVar, "viewWeakHolder");
        p.h(fVar, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/loader/impr/target/EmptyTarget$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "libimageloader_release"})
    /* renamed from: com.tencent.mm.loader.e.b.a$a  reason: collision with other inner class name */
    public static final class C0402a {
        private C0402a() {
        }

        public /* synthetic */ C0402a(byte b2) {
            this();
        }
    }
}
