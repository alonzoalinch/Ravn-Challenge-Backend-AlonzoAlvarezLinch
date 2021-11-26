package challenge.ravn.service;

import challenge.ravn.model.entity.BestSeller;
import challenge.ravn.repository.SalesRepository;
import challenge.ravn.response.SalesResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class SalesService {
    private final SalesRepository salesRepository;

    public ArrayList<SalesResponse> getBestSellers(Integer count) {
        ArrayList<SalesResponse> salesResponseList = new ArrayList<>();

        for (BestSeller bestSeller : salesRepository.findAuthorByRevenue(count)) {
            salesResponseList.add(new SalesResponse(bestSeller.getAuthor(), bestSeller.getRevenue()));
        }
        return salesResponseList;
    }
}
