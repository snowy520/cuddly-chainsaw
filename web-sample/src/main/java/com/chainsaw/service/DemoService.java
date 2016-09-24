package com.chainsaw.service;

import com.chainsaw.bean.Company;
import com.chainsaw.bean.InParam;

import java.util.List;

/**
 * Created by richard on 8/31/16 10:56 PM.
 */
public interface DemoService {

    void testValidator(InParam inParam);

    List<Company> testCache();

}
