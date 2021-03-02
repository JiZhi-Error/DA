package com.tencent.mm.plugin.finder.live.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.avn;
import com.tencent.mm.protocal.protobuf.awq;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\n\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\n\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\n\u0010\f\u001a\u0004\u0018\u00010\tH\u0016J\n\u0010\r\u001a\u0004\u0018\u00010\tH\u0016J\n\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\n\u0010\u0012\u001a\u0004\u0018\u00010\u000bH\u0016J\n\u0010\u0013\u001a\u0004\u0018\u00010\tH\u0016J\n\u0010\u0014\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0017"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/model/FinderLiveTextMsg;", "Lcom/tencent/mm/plugin/finder/live/model/IFinderLiveMsg;", "msg", "Lcom/tencent/mm/protocal/protobuf/FinderLiveMsg;", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveMsg;)V", "getMsg", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveMsg;", "setMsg", "getContent", "", "getFromContact", "Lcom/tencent/mm/protocal/protobuf/FinderLiveContact;", "getFromUserName", "getFromUserNickName", "getPayLoadContent", "", "getSeq", "", "getToContact", "getToUserName", "getToUserNickName", "getType", "", "plugin-finder_release"})
public class r implements t {
    public awq uke;

    public r(awq awq) {
        p.h(awq, "msg");
        AppMethodBeat.i(246272);
        this.uke = awq;
        AppMethodBeat.o(246272);
    }

    @Override // com.tencent.mm.plugin.finder.live.model.t
    public final int getType() {
        return this.uke.type;
    }

    @Override // com.tencent.mm.plugin.finder.live.model.t
    public final String csW() {
        FinderContact finderContact;
        avn avn = this.uke.LHp;
        if (avn == null || (finderContact = avn.contact) == null) {
            return null;
        }
        return finderContact.username;
    }

    @Override // com.tencent.mm.plugin.finder.live.model.t
    public final String getContent() {
        return this.uke.content;
    }

    @Override // com.tencent.mm.plugin.finder.live.model.t
    public final Object dft() {
        return null;
    }

    @Override // com.tencent.mm.plugin.finder.live.model.t
    public final String dfr() {
        FinderContact finderContact;
        avn avn = this.uke.LHp;
        if (avn == null || (finderContact = avn.contact) == null) {
            return null;
        }
        return finderContact.nickname;
    }

    @Override // com.tencent.mm.plugin.finder.live.model.t
    public final avn dfs() {
        return this.uke.LHp;
    }

    @Override // com.tencent.mm.plugin.finder.live.model.t
    public final avn hTa() {
        return this.uke.Vjm;
    }

    @Override // com.tencent.mm.plugin.finder.live.model.t
    public final long cKo() {
        return this.uke.seq;
    }

    @Override // com.tencent.mm.plugin.finder.live.model.t
    public final String hTb() {
        return "";
    }

    @Override // com.tencent.mm.plugin.finder.live.model.t
    public final String hTc() {
        return "";
    }
}
