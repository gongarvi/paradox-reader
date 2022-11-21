package com.paradoxcalculator.europa.batch;

import com.paradoxcalculator.europa.batch.steps.SplitStep;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepListener;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import java.io.InputStream;

@EnableBatchProcessing
@Configuration
public class FileReaderJobConfiguration {
    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Autowired
    public JobRepository jobRepository;

    @Autowired
    public SplitStep splitStep;


    public JobLauncher jobFileReader(InputStream file) throws Exception{
        SimpleJobLauncher jobLauncher = new SimpleJobLauncher();
        jobLauncher.setJobRepository(jobRepository);
        jobLauncher.setTaskExecutor(new SimpleAsyncTaskExecutor());
        jobLauncher.afterPropertiesSet();
        return jobLauncher;
    }

    @Bean
    public Job processFileReaderJob(String file){
        return jobBuilderFactory.get("")
                .incrementer(new RunIdIncrementer())
                .repository(jobRepository)
                .start(splitStep.buildStep(file)).on("COMPLETED")
                    .to(parseFile()).on("COMPLETED").end()
                .end()
                .build();
    }


    public Step parseFile(){
        return stepBuilderFactory.get("splitFile").chunk(1)

                .build();
    }

    public static class Proceso implements ItemProcessor<String, String>{

        @Override
        public String process(String item) throws Exception {
            return null;
        }
    }
}
