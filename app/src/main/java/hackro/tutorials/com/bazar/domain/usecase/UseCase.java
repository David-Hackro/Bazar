package hackro.tutorials.com.bazar.domain.usecase;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.Subscriptions;
public abstract class UseCase {


        private Subscription subscription = Subscriptions.empty();

        protected UseCase() {
        }

        @SuppressWarnings("unchecked")
        public void execute(Subscriber UseCaseSubscriber) {
            this.subscription = this.buildObservableUseCase()
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe(UseCaseSubscriber);
        }

        /**
         * Unsubscribes from current {@link rx.Subscription}.
         */
        public void unsubscribe() {
            if (!subscription.isUnsubscribed()) {
                subscription.unsubscribe();
            }
        }

        protected abstract Observable buildObservableUseCase();
    }
