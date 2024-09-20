package org.payment.gui.mapper.response;

import com.equens.bil.core.dto.Branch;
import org.payment.gui.model.internals.BranchHeader;


public class BranchTranslator {
    public BranchHeader toBranchHeaderResponse(Branch branch){
        BranchHeader bh = null;
        if(null != branch){
            bh = new BranchHeader();


            if(null !=branch.getId()){
                bh.setId(Long.valueOf(String.valueOf(branch.getId())));
            }
            if(null !=branch.getName()){
                bh.setName(branch.getName());
            }


        }
        return bh;
    }
}
