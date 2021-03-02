package com.tencent.mm.plugin.finder.live.model;

import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.aut;
import com.tencent.mm.protocal.protobuf.avn;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\n\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\n\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\n\u0010\f\u001a\u0004\u0018\u00010\tH\u0016J\n\u0010\r\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\n\u0010\u0010\u001a\u0004\u0018\u00010\u000bH\u0016J\n\u0010\u0011\u001a\u0004\u0018\u00010\tH\u0016J\n\u0010\u0012\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/model/FinderLiveBaseMsg;", "Lcom/tencent/mm/plugin/finder/live/model/IFinderLiveMsg;", "msg", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;)V", "getMsg", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "setMsg", "getContent", "", "getFromContact", "Lcom/tencent/mm/protocal/protobuf/FinderLiveContact;", "getFromUserName", "getFromUserNickName", "getSeq", "", "getToContact", "getToUserName", "getToUserNickName", "getType", "", "plugin-finder_release"})
public abstract class c implements t {
    aut uio;

    public c(aut aut) {
        p.h(aut, "msg");
        this.uio = aut;
    }

    @Override // com.tencent.mm.plugin.finder.live.model.t
    public final int getType() {
        return this.uio.ybm;
    }

    @Override // com.tencent.mm.plugin.finder.live.model.t
    public final String getContent() {
        return "";
    }

    @Override // com.tencent.mm.plugin.finder.live.model.t
    public final String csW() {
        FinderContact finderContact;
        avn avn = this.uio.LFE;
        if (avn == null || (finderContact = avn.contact) == null) {
            return null;
        }
        return finderContact.username;
    }

    @Override // com.tencent.mm.plugin.finder.live.model.t
    public final String dfr() {
        FinderContact finderContact;
        avn avn = this.uio.LFE;
        if (avn == null || (finderContact = avn.contact) == null) {
            return null;
        }
        return finderContact.nickname;
    }

    @Override // com.tencent.mm.plugin.finder.live.model.t
    public final avn dfs() {
        return this.uio.LFE;
    }

    @Override // com.tencent.mm.plugin.finder.live.model.t
    public final avn hTa() {
        return this.uio.LFz;
    }

    @Override // com.tencent.mm.plugin.finder.live.model.t
    public final long cKo() {
        return this.uio.seq;
    }

    @Override // com.tencent.mm.plugin.finder.live.model.t
    public final String hTb() {
        FinderContact finderContact;
        avn avn = this.uio.LFz;
        if (avn == null || (finderContact = avn.contact) == null) {
            return null;
        }
        return finderContact.username;
    }

    @Override // com.tencent.mm.plugin.finder.live.model.t
    public final String hTc() {
        FinderContact finderContact;
        avn avn = this.uio.LFz;
        if (avn == null || (finderContact = avn.contact) == null) {
            return null;
        }
        return finderContact.nickname;
    }
}
