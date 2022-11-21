package com.paradoxcalculator.europa.batch.steps;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class SplitStep{

    @Autowired
    protected StepBuilderFactory stepBuilderFactory;


    public Step buildStep(String file){
        return stepBuilderFactory.get("splitFile").<String, String>chunk(1)
                .reader(reader(file))
                .processor(process())
                .writer(writer())
                .build();
    }

    private ItemReader<String> reader(String file){
        class Reader implements ItemReader<String>{
            private String file;
            public Reader(String file){
                this.file=file;
            }

            @Override
            public String read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
                return file;
            }
        }
        return new Reader(file);
    }

    private ItemProcessor<String, String> process() {
        class Process implements ItemProcessor<String, String> {

            @Override
            public String process(String item) throws Exception {
                return null;
            }
        }
        return new Process();
    }

    private ItemWriter<String> writer() {
        class Writer implements ItemWriter<String> {
            @Override
            public void write(List<? extends String> items) throws Exception {

            }
        }
        return new Writer();
    }
}
