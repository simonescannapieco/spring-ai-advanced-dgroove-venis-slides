            ...
            
            /*
             * Order by decreasing costs
             */

            analysis.costByModel.entrySet().stream()
                    .sorted(Map.Entry.<String, Float>comparingByValue().reversed())
                    .forEach(entry -> {
                        logger.info(String.format("   >>> %-25s: %.6f USD", entry.getKey(), entry.getValue()));
                    });

            logger.info("----------------------------------------------------------------");
        }

        return chatClientResponse;

    }

    private static class CostAnalysis {
        Map<String, Float> costByModel = new HashMap<>();
    }

}