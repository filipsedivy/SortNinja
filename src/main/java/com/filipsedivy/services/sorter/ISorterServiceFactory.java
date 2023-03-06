package com.filipsedivy.services.sorter;

import com.filipsedivy.services.console.Arguments;

public interface ISorterServiceFactory {
  ISorterService create(Arguments arguments);
}
