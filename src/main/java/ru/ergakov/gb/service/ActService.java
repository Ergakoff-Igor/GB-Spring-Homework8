package ru.ergakov.gb.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ergakov.gb.aspects.TrackUserAction;
import ru.ergakov.gb.model.Act;
import ru.ergakov.gb.repositories.ActRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class ActService {
    private final ActRepository actRepository;

    /**
     * Метод получения списка всех актов
     *
     * @return список актов
     */
    @TrackUserAction
    @Transactional
    public List<Act> findAll(){
        return actRepository.findAll();
    }

    /**
     * Метод сохранения акта
     *
     * @param act акт
     * @return слхраненный акт
     */
    @TrackUserAction
    @Transactional
    public Act saveAct(Act act){
        return actRepository.save(act);
    }

    /**
     * Метод удаления акта по id
     *
     * @param id id акта
     */
    @TrackUserAction
    @Transactional
    public void deleteById(int id){
        actRepository.deleteById(id);
    }

    /**
     * Метод нахождения акта по id
     *
     * @param id id акта
     * @return акт
     */
    @TrackUserAction
    @Transactional
    public Act getOneActByID(int id)  {
       return actRepository.getOne(id);
    }

    /**
     * Метод изменения акта
     *
     * @param act акт, найденный через метод "getOne"
     * @return измененный акт
     */
    @TrackUserAction
    @Transactional
    public Act updateAct(Act act){
        return actRepository.updateAct(act);
    }
}
