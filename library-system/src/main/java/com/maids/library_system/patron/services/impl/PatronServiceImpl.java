package com.maids.library_system.patron.services.impl;

import com.maids.library_system.patron.entities.Patron;
import com.maids.library_system.patron.models.request.PatronReqModel;
import com.maids.library_system.patron.models.response.PatronResModel;
import com.maids.library_system.patron.repositories.PatronRepository;
import com.maids.library_system.patron.services.PatronService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@AllArgsConstructor
public class PatronServiceImpl implements PatronService {

    private final PatronRepository patronRepository;
    private final ModelMapper patronMapper;

    public int createPatron(PatronReqModel patronReqModel) {
        Patron patron = new Patron();
        mapPatronReqModelToPatron(patron, patronReqModel);
        patronRepository.save(patron);
        return patron.getId();
    }

    @Override
    public int updatePatron(int patronId, PatronReqModel patronReqModel) {
        Patron updatedPatron = patronRepository.findById(patronId).orElseThrow(() -> new RuntimeException("Patron not found"));
        mapPatronReqModelToPatron(updatedPatron, patronReqModel);
        patronRepository.save(updatedPatron);
        return updatedPatron.getId();
    }


    @Override
    public PatronResModel getPatronById(int patronId) {
        Patron patron = patronRepository.findById(patronId).orElseThrow(() -> new RuntimeException("Patron not found"));
        return patronMapper.map(patron, PatronResModel.class);
    }

    @Override
    public List<PatronResModel> getAllPatrons() {
        return Collections.singletonList(patronMapper.map(patronRepository.findAll(), PatronResModel.class));
    }

    @Override
    public void deletePatronById(int patronId) {
        patronRepository.deleteById(patronId);
    }


    private void mapPatronReqModelToPatron(Patron patron, PatronReqModel patronReqModel) {
        patron.setName(patronReqModel.getName());
        patron.setEmail(patronReqModel.getEmail());
        patron.setMobile(patronReqModel.getMobile());
    }

}
