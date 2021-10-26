package com.ms4i.dp.behavioral.strategy.singlefile;

import java.util.Objects;
import java.util.Optional;

/**
 * Project: arizona-ddi
 *
 * @author: johnee
 * @since: 26.10.2021
 */
public class FindPaymentInstruction {

    /*private Optional<ECPaymentGatewaySubscription> findSubscription(TransactionEntryRequestDTO requestDTO) {
    return Optional.ofNullable(findByPaymentInstructionId(requestDTO)
            .orElseGet(() -> findByPolicyNo(requestDTO)
                    .orElseGet(() -> findByPolicyNumber(requestDTO)
                            .orElseGet(() -> findByBillingNumber(requestDTO)
                                    .orElse(null)
                            )
                    )
            ));
}

    private Optional<ECPaymentGatewaySubscription> findByPolicyNumber(TransactionEntryRequestDTO requestDTO) {
        return new SubscriptionFinder().find(new SubscriptionFinderStrategyByPolicyNumber(), requestDTO);
    }

    private Optional<ECPaymentGatewaySubscription> findByPolicyNo(TransactionEntryRequestDTO requestDTO) {
        return new SubscriptionFinder().find(new SubscriptionFinderStrategyByPolicyNo(), requestDTO);
    }

    private Optional<ECPaymentGatewaySubscription> findByPaymentInstructionId(TransactionEntryRequestDTO requestDTO) {
        return new SubscriptionFinder().find(new SubscriptionFinderStrategyByPaymentInstructionId(), requestDTO);
    }

    private Optional<ECPaymentGatewaySubscription> findByBillingNumber(TransactionEntryRequestDTO requestDTO) {
        return new SubscriptionFinder().find(new SubscriptionFinderStrategyByBillingNumber(), requestDTO);
    }

interface ISubscriptionFinderStrategy {
    Optional<ECPaymentGatewaySubscription> find(TransactionEntryRequestDTO requestDTO);
}

class SubscriptionFinderStrategyByPaymentInstructionId implements ISubscriptionFinderStrategy {

    @Override
    public Optional<ECPaymentGatewaySubscription> find(TransactionEntryRequestDTO requestDTO) {

        if (null == requestDTO.getPaymentInstructionId()) {
            return Optional.empty();
        }

        return Optional.ofNullable(
                paymentInstructionService.findOne(requestDTO.getPaymentInstructionId()))
                .map(PaymentInstruction::getPaymentGatewaySubscription)
                .map(ECPaymentGatewaySubscription.class::cast);
    }
}

class SubscriptionFinderStrategyByPolicyNo implements ISubscriptionFinderStrategy {

    @Override
    public Optional<ECPaymentGatewaySubscription> find(TransactionEntryRequestDTO requestDTO) {

        if (null == requestDTO.getPolicyNo()) {
            return Optional.empty();
        }

        PaymentInstructionSearchDTO searchDTO = new PaymentInstructionSearchDTO();
        searchDTO.setPolicyNo(requestDTO.getPolicyNo());

        return paymentInstructionService.searchList(searchDTO)
                .stream()
                .filter(Objects::nonNull)
                .map(PaymentInstruction::getPaymentGatewaySubscription)
                .map(ECPaymentGatewaySubscription.class::cast)
                .findFirst();
    }
}

class SubscriptionFinderStrategyByPolicyNumber implements ISubscriptionFinderStrategy {

    @Override
    public Optional<ECPaymentGatewaySubscription> find(TransactionEntryRequestDTO requestDTO) {

        if (null == requestDTO.getPolicyNumber()) {
            return Optional.empty();
        }

        PaymentInstructionSearchDTO searchDTO = new PaymentInstructionSearchDTO();
        searchDTO.setPolicyNumber(requestDTO.getPolicyNumber());

        return paymentInstructionService.searchList(searchDTO)
                .stream()
                .filter(Objects::nonNull)
                .map(PaymentInstruction::getPaymentGatewaySubscription)
                .map(ECPaymentGatewaySubscription.class::cast)
                .findFirst();
    }
}

class SubscriptionFinderStrategyByBillingNumber implements ISubscriptionFinderStrategy {

    @Override
    public Optional<ECPaymentGatewaySubscription> find(TransactionEntryRequestDTO requestDTO) {

        if (null == requestDTO.getBillingNumber()) {
            return Optional.empty();
        }

        PaymentInstructionSearchDTO searchDTO = new PaymentInstructionSearchDTO();
        searchDTO.setBillingNumber(requestDTO.getBillingNumber());

        return paymentInstructionService.searchList(searchDTO)
                .stream()
                .filter(Objects::nonNull)
                .map(PaymentInstruction::getPaymentGatewaySubscription)
                .map(ECPaymentGatewaySubscription.class::cast)
                .findFirst();
    }
}

class SubscriptionFinder {
    public Optional<ECPaymentGatewaySubscription> find(ISubscriptionFinderStrategy strategy, TransactionEntryRequestDTO dto) {
        log.info("!!! Start find Subscription using : " + strategy.getClass().getSimpleName());
        return strategy.find(dto);
    }
}
*/
}