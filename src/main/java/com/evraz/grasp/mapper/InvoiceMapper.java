package com.evraz.grasp.mapper;

import com.evraz.grasp.dto.InvoiceDTO;
import com.evraz.grasp.entity.Invoice;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InvoiceMapper {

    InvoiceDTO toDTO(Invoice invoice);
    Invoice toEntity(InvoiceDTO invoiceDTO);

}
