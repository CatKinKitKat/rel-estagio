/**
 * Finds webshops via a conditionally defined
 * query sorted by a defined sort field.
 *
 * @param condition the condition
 * @param sortField the sort field
 * @return the webshops
 */
public Mono<MutableHttpResponse<List<WebshopModel>>>
    getWebshops(Condition condition, SortField<?> sortField) {

    return webshopRepository.findVarious(condition, sortField)
        .flatMapSequential(this::getWebshopPriv)
        .collectList().flatMap(webshops -> {
            if (webshops.isEmpty()) {
            return Mono.empty();
        }
    return Mono.just(HttpResponse.ok(webshops));
    }).switchIfEmpty(Mono.just(HttpResponse.notFound()))
    .onErrorReturn(HttpResponse.serverError());
}