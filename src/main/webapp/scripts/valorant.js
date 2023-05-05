$(".btn-open").on("click", function() {
    let title = $(this).attr("data-title");
    let population = $(this).attr("data-team");
    let region = $(this).attr("data-region");
    // console.log(`${title} ${team} ${region}`);
    $(".modal-title").html(title);
    $(".modal-team").html(population);
    $(".modal-region").html(region);
});