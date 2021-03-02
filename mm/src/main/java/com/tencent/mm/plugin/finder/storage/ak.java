package com.tencent.mm.plugin.finder.storage;

import android.content.Context;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.b;
import com.tencent.mm.plugin.finder.storage.data.g;
import com.tencent.mm.protocal.protobuf.FinderContact;
import java.util.LinkedList;
import java.util.List;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\"J\b\u0010\u0002\u001a\u00020\u0003H&J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tH&J\u001a\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\rH&J\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\f\u001a\u0004\u0018\u00010\rH&J\u0016\u0010\u0010\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000fH&J\b\u0010\u0012\u001a\u00020\u0007H&J\b\u0010\u0013\u001a\u00020\u0014H&J\b\u0010\u0015\u001a\u00020\u0003H&J\u0016\u0010\u0016\u001a\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H&J\u001c\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\n2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001eH&J\u0010\u0010\u001f\u001a\u00020\u00172\u0006\u0010 \u001a\u00020!H&¨\u0006#"}, hxF = {"Lcom/tencent/mm/plugin/finder/storage/IFinderBlockListConfig;", "", "canAddList", "", "getCache", "Lcom/tencent/mm/plugin/finder/storage/data/FinderContactPage;", "getEmptyTips", "", "getInitData", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "getItemData", "netScene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "getLastBuff", "Lcom/tencent/mm/protobuf/ByteString;", "getNetScene", "lastBuff", "getSubTitleStr", "getTitleStrId", "", "needLoadMore", "onAddUserList", "", "nameList", "", "", "onItemDelete", "contact", "callBack", "Lcom/tencent/mm/plugin/finder/storage/IFinderBlockListConfig$OnItemDelCallBack;", "onSearchBarClick", "context", "Landroid/content/Context;", "OnItemDelCallBack", "plugin-finder_release"})
public interface ak {

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/finder/storage/IFinderBlockListConfig$OnItemDelCallBack;", "", "onDel", "", "success", "", "plugin-finder_release"})
    public interface a {
        void nN(boolean z);
    }

    void a(FinderContact finderContact, a aVar);

    q c(b bVar);

    int dql();

    boolean dqn();

    g dqo();

    LinkedList<FinderContact> dqp();

    boolean dqq();

    void es(List<String> list);

    void fq(Context context);

    CharSequence hUL();

    CharSequence hUM();

    b i(q qVar);

    LinkedList<FinderContact> j(q qVar);
}
